package com.example.githubusersapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubusersapp.data.remote.mappers.UserBaseInfoMapper
import com.example.githubusersapp.domain.UserBaseInfo
import javax.inject.Inject

class UsersPagingSource @Inject constructor(
    private val userApi: IUserApi,
    private val userBaseInfoMapper: UserBaseInfoMapper
) : PagingSource<Int, UserBaseInfo>() {

    override fun getRefreshKey(state: PagingState<Int, UserBaseInfo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserBaseInfo> {
        return try {
            val nextPageNumber = params.key ?: 0
            val usersList = userApi.getUsers(nextPageNumber)
            val nextKey = if (usersList.isEmpty()) null else nextPageNumber + usersList.size

            LoadResult.Page(
                data = userBaseInfoMapper.map(usersList),
                prevKey = null,
                nextKey = nextKey
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}