package com.example.popup_store

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextId: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextNickname: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextId = findViewById(R.id.editTextId)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextNickname = findViewById(R.id.editTextNickname)
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        buttonRegister = findViewById(R.id.buttonRegister)

        buttonRegister.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val id = editTextId.text.toString().trim()
        val password = editTextPassword.text.toString().trim()
        val nickname = editTextNickname.text.toString().trim()
        val phoneNumber = editTextPhoneNumber.text.toString().trim()

        if (id.isEmpty() || password.isEmpty() || nickname.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(this, "모든 필드를 입력하세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val intent = Intent(this, SurveyActivity::class.java)
        startActivity(intent)
        finish()
    }
}
