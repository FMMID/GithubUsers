package com.example.githubusersapp.domain

open class UserBaseInfo(
    val id: Long,
    val login: String,
    val avatar: String,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as UserBaseInfo
        if (id != other.id) return false
        if (login != other.login) return false
        if (avatar != other.avatar) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + login.hashCode()
        result = 31 * result + avatar.hashCode()
        return result
    }
}