package com.example.githubusersapp.data.base

interface BaseRemoteMapper<DATA, DOMAIN> {

    fun map(data: DATA): DOMAIN

    fun map(data: List<DATA>): List<DOMAIN> {
        return data.map(::map)
    }
}