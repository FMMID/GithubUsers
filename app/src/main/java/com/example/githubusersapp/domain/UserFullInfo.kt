package com.example.githubusersapp.domain

data class UserFullInfo(
    val userBaseInfo: UserBaseInfo,
    val email: String,
    val organization: String,
    val followingCount: Long,
    val followersCount: Long,
    val createdAt: String
)