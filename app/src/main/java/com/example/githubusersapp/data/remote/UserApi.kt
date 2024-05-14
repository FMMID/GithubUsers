package com.example.githubusersapp.data.remote

import com.example.githubusersapp.data.base.BaseApi
import com.example.githubusersapp.data.remote.response.UserBaseInfoResponse
import io.ktor.client.HttpClient
import javax.inject.Inject

private const val BASE_URL = "api.github.com"
private const val GET_USERS = "/users"

private const val PER_PAGE_DEFAULT = "10"
private const val SINCE_PARAM = "since"
private const val PER_PAGE_PARAM = "per_page"

class UserApi @Inject constructor(httpClient: HttpClient) : BaseApi(httpClient, BASE_URL), IUserApi {

    override suspend fun getUsers(since: Int): List<UserBaseInfoResponse> = get<List<UserBaseInfoResponse>>(
        endpoint = GET_USERS,
        queries = mapOf(
            SINCE_PARAM to since.toString(),
            PER_PAGE_PARAM to PER_PAGE_DEFAULT,
        )
    ).getOrDefault(emptyList())
}