package com.example.githubusersapp.di

import com.example.githubusersapp.data.UserRepository
import com.example.githubusersapp.data.remote.IUserRemoteStorage
import com.example.githubusersapp.data.remote.UserRemoteStorage
import com.example.githubusersapp.domain.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository

    @Binds
    abstract fun bindUserRemoteStorage(userRemoteStorage: UserRemoteStorage): IUserRemoteStorage
}