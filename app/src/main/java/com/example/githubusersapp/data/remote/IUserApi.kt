package com.example.githubusersapp.data.remote

import com.example.githubusersapp.data.remote.response.UserBaseInfoResponse

interface IUserApi {

    suspend fun getUsers(since: Int): List<UserBaseInfoResponse>
}