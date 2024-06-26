package com.example.githubusersapp.data.remote.mappers

import com.example.githubusersapp.data.base.BaseRemoteMapper
import com.example.githubusersapp.data.remote.response.UserBaseInfoResponse
import com.example.githubusersapp.domain.UserBaseInfo
import javax.inject.Inject

class UserBaseInfoMapper @Inject constructor() : BaseRemoteMapper<UserBaseInfoResponse, UserBaseInfo> {

    override fun map(data: UserBaseInfoResponse): UserBaseInfo = UserBaseInfo(
        id = data.id,
        login = data.login,
        avatar = data.avatar
    )
}