package com.example.githubusersapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserFullInfoResponse(
    @SerialName("login")
    val login: String,

    @SerialName("avatar_url")
    val avatar: String?,

    @SerialName("email")
    val email: String?,

    @SerialName("company")
    val organization: String?,

    @SerialName("following")
    val followingCount: Long,

    @SerialName("followers")
    val followersCount: Long,

    @SerialName("created_at")
    val createdAt: String
)