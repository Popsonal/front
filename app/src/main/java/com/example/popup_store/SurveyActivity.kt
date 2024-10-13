package com.example.popup_store

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class SurveyActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        radioGroup = findViewById(R.id.radioGroup)
        buttonNext = findViewById(R.id.buttonNext)

        buttonNext.setOnClickListener {
            submitSurvey()
        }
    }

    private fun submitSurvey() {
        val selectedId = radioGroup.checkedRadioButtonId
        val selectedOption: String

        if (selectedId != -1) {
            val radioButton = findViewById<RadioButton>(selectedId)
            selectedOption = radioButton.text.toString()

            // 선택한 옵션을 다음 단계로 전달하거나 처리
            val intent = Intent(this, NextActivity::class.java) // 다음 단계로 이동하는 액티비티를 지정하세요
            intent.putExtra("SELECTED_OPTION", selectedOption)
            startActivity(intent)
            finish() // 현재 액티비티 종료
        }
    }
}
