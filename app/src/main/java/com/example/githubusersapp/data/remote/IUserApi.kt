package com.example.githubusersapp.data.remote

import com.example.githubusersapp.data.remote.response.UserBaseInfoResponse
import com.example.githubusersapp.data.remote.response.UserFullInfoResponse

interface IUserApi {

    suspend fun getUsers(since: Int): List<UserBaseInfoResponse>

    suspend fun getUser(username: String): UserFullInfoResponse?
}