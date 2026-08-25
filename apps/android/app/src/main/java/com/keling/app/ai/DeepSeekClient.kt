package com.keling.app.ai

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.contentType
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * 云端 AI 客户端安全占位实现。
 *
 * Provider API keys must never be shipped in an APK. AI calls are disabled in
 * the Android preview until this client is wired to the authenticated backend.
 */
class DeepSeekClient {

    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 30_000
            connectTimeoutMillis = 10_000
        }

        expectSuccess = false

        defaultRequest { contentType(ContentType.Application.Json) }
    }

    suspend fun chat(systemPrompt: String, userPrompt: String): String {
        // Deliberately fail closed. A future backend client must send the user's
        // bearer token to /api/ai/chat; it must not call the provider directly.
        throw IllegalStateException("云端 AI 暂未启用：请先完成安全后端接入")
    }

    fun close() {
        client.close()
    }
}

