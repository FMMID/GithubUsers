package com.example.githubusersapp.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    fun getFlowOfUsers(): Flow<PagingData<UserBaseInfo>>
}