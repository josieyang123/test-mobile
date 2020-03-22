package com.josie.usermodule.injection.module

import com.josie.usermodule.service.UserService
import com.josie.usermodule.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * @description :
 * created by josie at 2020/3/21
 */
@Module
class UserModule {
    @Provides
    @Named("service")
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }
}