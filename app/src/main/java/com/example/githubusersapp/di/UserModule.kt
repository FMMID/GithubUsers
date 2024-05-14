package com.example.githubusersapp.di

import com.example.githubusersapp.data.UserRepository
import com.example.githubusersapp.data.remote.IUserApi
import com.example.githubusersapp.data.remote.UserApi
import com.example.githubusersapp.domain.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository

    @Binds
    abstract fun bindUserRemoteStorage(userApi: UserApi): IUserApi

}