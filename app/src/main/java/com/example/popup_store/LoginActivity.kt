package com.example.popup_store

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextNickname: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonSignUp: Button // 회원가입 버튼 추가

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextNickname = findViewById(R.id.editTextNickname)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonSignUp = findViewById(R.id.buttonSignUp) // 회원가입 버튼 초기화

        buttonLogin.setOnClickListener {
            loginUser()
        }

        buttonSignUp.setOnClickListener { // 회원가입 버튼 클릭 리스너 추가
            val intent = Intent(this, RegisterActivity::class.java) // RegisterActivity로 이동
            startActivity(intent)
        }
    }

    private fun loginUser() {
        val nickname = editTextNickname.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (nickname.isEmpty() || password.isEmpty()) {
            return // 필드가 비어있는 경우 처리
        }

        // MainActivity로 이동
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("USER_NICKNAME", nickname)
        }
        startActivity(intent)
        finish() // 현재 액티비티 종료
    }
}
