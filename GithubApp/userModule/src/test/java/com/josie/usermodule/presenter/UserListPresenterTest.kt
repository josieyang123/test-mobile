package com.josie.usermodule.presenter
import com.josie.usermodule.ImmediateSchedulerRule
import com.josie.usermodule.presenter.view.UserListView
import com.josie.usermodule.service.impl.UserServiceImpl
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import org.junit.*

import org.mockito.Mock
import org.mockito.MockitoAnnotations


/**
 * @description : The test class of UserListPresenter
 * created by josie at 2020/3/23
 */
class UserListPresenterTest {
    companion object {
        @get:Rule
        val schedulers = ImmediateSchedulerRule()
    }
    @Mock
    private lateinit var view: UserListView
    @Mock
    private lateinit var service: UserServiceImpl
    private lateinit var presenter:UserListPresenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter= UserListPresenter()
        presenter.userService=service
        presenter.mView=view
    }


    @Test
    fun getAllUsers() {
        presenter.getAllUsers(1)
        verify(service).getAllUsers(any())
        verify(view).onGetAllUsersResult(any())
    }

    @Test
    fun searchUsers() {
        val name="josieyang123"
        presenter.searchUsers(name,1,20)
        verify(view).showLoading()
        verify(service).getAllUsers(any())
        verify(view).onSearchUsersResult(any())
        verify(view).hideLoading()
    }
}