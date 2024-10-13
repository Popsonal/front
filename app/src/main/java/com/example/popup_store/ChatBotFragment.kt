package com.example.popup_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import okhttp3.MediaType.Companion.toMediaType

class ChatBotFragment : Fragment() {

    private val client = OkHttpClient()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chatbot, container, false)
    }

    private fun sendMessageToOpenAI(message: String) {
        val url = "https://api.openai.com/v1/chat/completions"
        val apiKey = "YOUR_API_KEY" // 여기에 OpenAI API 키 입력

        // JSON 데이터 생성
        val json = JSONObject()
        json.put("model", "gpt-3.5-turbo") // 사용할 모델
        json.put("messages", JSONArray().put(JSONObject().put("role", "user").put("content", message)))

        // Request 생성
        val requestBody = RequestBody.create("application/json; charset=utf-8".toMediaType(), json.toString())
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $apiKey")
            .post(requestBody)
            .build()

        // API 호출
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    // 응답 처리
                    val responseData = response.body?.string()
                    val jsonResponse = JSONObject(responseData)
                    val botReply = jsonResponse.getJSONArray("choices").getJSONObject(0).getString("message")
                    updateChat(botReply) // 사용자 정의 함수
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
        })
    }

    private fun updateChat(message: String) {
        // UI에 챗봇 응답 추가하는 코드
    }
}
