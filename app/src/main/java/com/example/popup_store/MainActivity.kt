package com.example.popup_store

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.popup_store.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent에서 닉네임 받기
        val nickname = intent.getStringExtra("USER_NICKNAME")
        if (nickname != null) {
            Toast.makeText(this, "환영합니다, $nickname!", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // 현재 액티비티 종료
            return // 더 이상 실행하지 않도록 반환
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.fragment_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment())
                        .commit()
                    true
                }
                R.id.fragment_map -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MapFragment())
                        .commit()
                    true
                }
                R.id.fragment_event -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, EventFragment())
                        .commit()
                    true
                }
                R.id.fragment_map -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MapFragment())
                        .commit()
                    true
                }
                R.id.fragment_chatbot -> { // 챗봇 Fragment로 전환
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ChatBotFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
