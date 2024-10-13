package com.example.popup_store

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivity : AppCompatActivity() {

    private lateinit var textViewFinal: TextView
    private lateinit var radioGroupPreference: RadioGroup
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        radioGroupPreference = findViewById(R.id.radioGroupPreference)
        buttonSubmit = findViewById(R.id.buttonSubmit)

        // Intent로부터 방문 목적 가져오기
        val visitPurpose = intent.getStringExtra("VISIT_PURPOSE")
        textViewFinal.text = "방문 목적: $visitPurpose"

        buttonSubmit.setOnClickListener {
            submitPreferences()
        }
    }

    private fun submitPreferences() {
        val selectedId = radioGroupPreference.checkedRadioButtonId
        if (selectedId != -1) {
            val radioButton = findViewById<RadioButton>(selectedId)
            val preferredStore = radioButton.text.toString()

            // 결과 처리 후 로그인 화면으로 이동
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // 선택하지 않았을 때 처리 (예: 알림 표시)
        }
    }
}
