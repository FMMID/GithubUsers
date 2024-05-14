package com.example.githubusersapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubusersapp.data.local.UserLocalStorage
import com.example.githubusersapp.data.remote.IUserApi
import com.example.githubusersapp.data.remote.UsersPagingSource
import com.example.githubusersapp.data.remote.mappers.UserFullInfoMapper
import com.example.githubusersapp.domain.IUserRepository
import com.example.githubusersapp.domain.UserBaseInfo
import com.example.githubusersapp.domain.UserFullInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userLocalStorage: UserLocalStorage,
    private val usersPagingSource: UsersPagingSource,
    private val userApi: IUserApi,
    private val userFullInfoMapper: UserFullInfoMapper
) : IUserRepository {

    override fun getFlowOfUsers(): Flow<PagingData<UserBaseInfo>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { usersPagingSource }
    ).flow

    override suspend fun getUserInfo(userName: String): UserFullInfo? {
        return userFullInfoMapper.map(userApi.getUser(userName))
    }
}