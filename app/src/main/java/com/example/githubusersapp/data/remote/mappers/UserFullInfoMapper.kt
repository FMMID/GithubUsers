package com.example.githubusersapp.data.remote.mappers

import com.example.githubusersapp.data.base.BaseRemoteMapper
import com.example.githubusersapp.data.remote.response.UserFullInfoResponse
import com.example.githubusersapp.domain.UserBaseInfo
import com.example.githubusersapp.domain.UserFullInfo
import javax.inject.Inject

class UserFullInfoMapper @Inject constructor() : BaseRemoteMapper<UserFullInfoResponse?, UserFullInfo?> {

    override fun map(data: UserFullInfoResponse?): UserFullInfo? {
        return data?.let {
            UserFullInfo(
                userBaseInfo = UserBaseInfo(
                    id = 0L,
                    avatar = data.avatar ?: "",
                    login = data.login
                ),
                email = data.email ?: "",
                organization = data.organization ?: "",
                followersCount = data.followersCount,
                followingCount = data.followingCount,
                createdAt = data.createdAt
            )
        }
    }
}