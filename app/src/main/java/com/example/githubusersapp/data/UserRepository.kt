package com.example.githubusersapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubusersapp.data.local.UserLocalStorage
import com.example.githubusersapp.data.remote.UsersPagingSource
import com.example.githubusersapp.domain.IUserRepository
import com.example.githubusersapp.domain.UserBaseInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userLocalStorage: UserLocalStorage,
    private val usersPagingSource: UsersPagingSource
) : IUserRepository {

    override fun getFlowOfUsers(): Flow<PagingData<UserBaseInfo>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { usersPagingSource }
    ).flow
}