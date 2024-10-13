package com.example.popup_store

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {

    private lateinit var textViewSelectedOption: TextView
    private lateinit var radioGroupPurpose: RadioGroup
    private lateinit var buttonNextSurvey: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        radioGroupPurpose = findViewById(R.id.radioGroupPurpose)
        buttonNextSurvey = findViewById(R.id.buttonNextSurvey)

        // Intent로부터 선택된 옵션 가져오기
        val selectedOption = intent.getStringExtra("SELECTED_OPTION")
        textViewSelectedOption.text = "선택한 옵션: $selectedOption"

        buttonNextSurvey.setOnClickListener {
            submitPurpose()
        }
    }

    private fun submitPurpose() {
        val selectedId = radioGroupPurpose.checkedRadioButtonId
        if (selectedId != -1) {
            val radioButton = findViewById<RadioButton>(selectedId)
            val purpose = radioButton.text.toString()

            val intent = Intent(this, FinalActivity::class.java) // 다음 액티비티로 변경하세요
            intent.putExtra("VISIT_PURPOSE", purpose)
            startActivity(intent)
            finish()
        } else {
        }
    }
}
