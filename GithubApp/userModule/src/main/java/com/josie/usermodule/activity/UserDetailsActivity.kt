package com.josie.usermodule.activity

import android.os.Bundle
import android.view.View
import com.josie.baselibrary.common.BaseConstant
import com.josie.baselibrary.common.loadUrlRound
import com.josie.baselibrary.common.onClick
import com.josie.baselibrary.ui.BaseMvpActivity
import com.josie.baselibrary.utils.DateUtils
import com.josie.usermodule.R
import com.josie.usermodule.data.protocol.UserInfo
import com.josie.usermodule.injection.component.DaggerUserComponent
import com.josie.usermodule.injection.module.UserModule
import com.josie.usermodule.presenter.UserDetailsPresenter
import com.josie.usermodule.presenter.view.UserDetailsView
import kotlinx.android.synthetic.main.activity_user_details.*
import org.jetbrains.anko.toast

/**
 * @description : user details page
 * created by josie at 2020/3/21
 */
class UserDetailsActivity : BaseMvpActivity<UserDetailsPresenter>(), UserDetailsView {

    private var name: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        initView()
        loadData()
    }

    /**
     * @description  init Dagger
     * @param
     * @return
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }
    private fun initView() {
        name=intent.getStringExtra(BaseConstant.INTENT_USER_NAME)
        mLogin.text=name
        mIconBack.onClick(View.OnClickListener { finish() })
    }

    /**
     * @description  get user info by username
     * @param
     * @return
     */
    private fun loadData() {
        if (name.isNotEmpty()){
            mPresenter.getUser(name)
        }else{
            toast(R.string.param_error)
        }


    }

    /**
     * @description  callback of loadData()
     * @param
     * @return
     */
    override fun onGetUserResult(result: UserInfo) {
        mAvatar.loadUrlRound(result.avatar_url)
        mLocation.text=result.location
        mJoin.text="Joined at "+DateUtils.date2Str(result.created_at)
        mName.text=result.name
        mBio.text=result.bio
        mEmail.text=result.email
        mHtml.text=result.html_url
        mFollowers.text=result.followers.toString()
        mFollowing.text=result.following.toString()
        mRepo.text=result.public_repos.toString()
        mGists.text=result.public_gists.toString()
    }

}
