package com.example.githubusersapp.data.base

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.URLProtocol
import io.ktor.http.isSuccess
import io.ktor.http.path
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseApi(
    val httpClient: HttpClient,
    private val baseUrl: String
) {

    suspend inline fun <reified T> get(
        endpoint: String,
        queries: Map<String, String> = mapOf(),
        path: List<String> = emptyList(),
    ): Result<T> {
        return withContext(Dispatchers.IO) {
            handleResponse(
                httpClient.get {
                    configureBaseRequest(endpoint, path)
                    url {
                        queries.forEach { query ->
                            parameters.append(query.key, query.value)
                        }
                    }
                }
            )
        }
    }

    suspend inline fun <reified T> handleResponse(response: HttpResponse): Result<T> {
        if (response.status.isSuccess()) {
            return Result.success(response.body())
        }

        val error = try {
            response.body()
        } catch (exception: Exception) {
            exception
        }

        return Result.failure(error)
    }

    fun HttpRequestBuilder.configureBaseRequest(
        endpoint: String,
        path: List<String> = emptyList()
    ) {
        url {
            protocol = URLProtocol.HTTPS
            host = baseUrl

            path()

            if (path.isEmpty()) {
                path(endpoint)
            } else {
                path(endpoint)
                pathSegments = listOf(endpoint) + path
            }
        }
    }
}