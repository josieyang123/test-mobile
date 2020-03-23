package com.josie.usermodule.presenter
import com.josie.usermodule.ImmediateSchedulerRule
import com.josie.usermodule.presenter.view.UserDetailsView
import com.josie.usermodule.service.impl.UserServiceImpl
import com.nhaarman.mockitokotlin2.any
import org.junit.*

import org.mockito.Mockito.verify
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.junit.ClassRule




/**
 * @description : The test class of UserDetailsPresenter
 * created by josie at 2020/3/23
 */
class UserDetailsPresenterTest {
    companion object {
        @get:Rule
        val schedulers = ImmediateSchedulerRule()
    }
    @Mock
    private lateinit var view: UserDetailsView
    @Mock
    private lateinit var service: UserServiceImpl
    private lateinit var presenter:UserDetailsPresenter


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter=UserDetailsPresenter()
        presenter.userService=service
        presenter.mView=view
    }

    @Test
    fun getUser() {
        val name="josieyang123"
        presenter.getUser(name)
        verify(view).showLoading()
        verify(service).getUser(any())
        verify(view).onGetUserResult(any())
        verify(view).hideLoading()
    }

    @After
    fun tearDown() {
    }
}