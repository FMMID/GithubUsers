package com.example.githubusersapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserBaseInfoResponse(

    @SerialName("login")
    val login: String,

    @SerialName("id")
    val id: Long,

    @SerialName("avatar_url")
    val avatar: String
)