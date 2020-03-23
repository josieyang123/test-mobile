package com.josie.usermodule.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.view.View
import com.josie.baselibrary.common.BaseConstant
import com.josie.baselibrary.common.onClick
import com.josie.baselibrary.ui.BaseMvpActivity
import com.josie.baselibrary.ui.BaseRecyclerViewAdapter
import com.josie.baselibrary.utils.LogUtils
import com.josie.baselibrary.widget.DefaultTextWatcher
import com.josie.usermodule.adapter.UserListAdapter
import com.josie.usermodule.data.protocol.SearchUserResp
import com.josie.usermodule.data.protocol.UserInfo
import com.josie.usermodule.injection.component.DaggerUserComponent
import com.josie.usermodule.injection.module.UserModule
import com.josie.usermodule.presenter.UserListPresenter
import com.josie.usermodule.presenter.view.UserListView
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.activity_user_list.*
import org.jetbrains.anko.startActivity
import com.josie.usermodule.R
import com.josie.usermodule.adapter.LinearDecoration
import org.jetbrains.anko.toast


/**
 * @description : The home page, display the users list, andr you can search users by username
 * created by josie at 2020/3/20
 */
class UserListActivity : BaseMvpActivity<UserListPresenter>(), UserListView {

    private lateinit var mUserListAdapter: UserListAdapter
    private var mUsersPage: Int = 1
    private var mSearchPage: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        initView()
    }

    override fun onStop() {
        super.onStop()
        finishRefresh()
    }

    /**
     * @description  init Dagger
     * @param
     * @return
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule())
            .build().inject(this)
        mPresenter.mView = this
    }

    private fun initView() {
        initRefreshLayout()
        initRecyclerView()
        mSearch.onClick(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (mEditText.text.toString().isNotEmpty()){
                    mSearchPage=1
                    searchUsers(mEditText.text.toString())
                }else{
                    toast(R.string.please_input_search)
                }
            }
        })
        mEditText.addTextChangedListener(object : DefaultTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                if (mEditText.text.toString().isNotEmpty()){
                    mRefreshLayout.setEnableRefresh(false)
                }else{
                    mRefreshLayout.setEnableRefresh(true)
                }
            }
        })
    }

    private fun initRefreshLayout() {
        mRefreshLayout.setDragRate(0.6f)
        mRefreshLayout.setPrimaryColorsId(R.color.colorPrimary,R.color.common_white)
        mRefreshLayout.setRefreshHeader(MaterialHeader(this))
        mRefreshLayout.setRefreshFooter(ClassicsFooter(this))
        mRefreshLayout.setEnableLoadMoreWhenContentNotFull(false)
        mRefreshLayout.setOnRefreshListener(object : OnRefreshListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                LogUtils.base()
                mUsersPage = 1
                loadUsers()
            }
        })
        mRefreshLayout.setOnLoadMoreListener(object : OnLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                LogUtils.base()
                if (mEditText.text.toString().isNotEmpty()){
                    mSearchPage++
                    searchUsers(mEditText.text.toString())
                }else{
                    mUsersPage++
                    loadUsers()
                }

            }
        })
        mRefreshLayout.setEnableRefresh(true)
        mRefreshLayout.autoRefresh()
    }
    private fun initRecyclerView() {
        mUserListRcv.layoutManager = LinearLayoutManager(this)
        mUserListRcv.addItemDecoration(LinearDecoration(24, 30))
        mUserListAdapter = UserListAdapter(this)
        mUserListRcv.adapter = mUserListAdapter
        mUserListAdapter.setOnItemClickListener(object :
            BaseRecyclerViewAdapter.OnItemClickListener<UserInfo> {
            override fun onItemClick(item: UserInfo, position: Int) {
                startActivity<UserDetailsActivity>(BaseConstant.INTENT_USER_NAME to item.login)
            }
        })
    }

    /**
     * @description  get all users of github
     * @param
     * @return
     */
    private fun loadUsers() {
        mPresenter.getAllUsers(mUsersPage)
    }

    /**
     * @description  search users by username, It is limited to return 20 data at a time
     * @param name : username
     * @return
     */
    private fun searchUsers(name: String) {
        mPresenter.searchUsers(name, mSearchPage, 20)
    }
    /**
     * @description  close refresh
     * @param
     * @return
     */
    private fun finishRefresh() {
        mRefreshLayout.finishRefresh()
        mRefreshLayout.finishLoadMore()
    }

    /**
     * @description  callback of searchUsers()
     * @param
     * @return
     */
    override fun onSearchUsersResult(result: SearchUserResp) {
        finishRefresh()
        hideLoading()
        if (result != null ) {
            if (result.message!=null) {
                toast(result.message)
            }else if (result.items != null && result.items.size > 0){
                if (mSearchPage == 1) {
                    mUserListAdapter.setData(result.items)
                } else {
                    mUserListAdapter.dataList.addAll(result.items)
                    mUserListAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    /**
     * @description  callback of loadUsers()
     * @param
     * @return
     */
    override fun onGetAllUsersResult(result: MutableList<UserInfo>) {
        finishRefresh()
        if (result != null && result.size > 0) {
            if (mUsersPage == 1) {
                mUserListAdapter.setData(result)
            } else {
                mUserListAdapter.dataList.addAll(result)
                mUserListAdapter.notifyDataSetChanged()
            }
        }
    }

    /**
     * @description  error callback of request
     * @param
     * @return
     */
    override fun onError(text: String) {
        super.onError(text)
        finishRefresh()
    }
}
