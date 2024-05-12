package com.example.githubusersapp.data

import com.example.githubusersapp.data.local.UserLocalStorage
import com.example.githubusersapp.data.remote.IUserRemoteStorage
import com.example.githubusersapp.domain.IUserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userLocalStorage: UserLocalStorage,
    private val userRemoteStorage: IUserRemoteStorage,
    private val userMapper: UserMapper
) : IUserRepository {

}