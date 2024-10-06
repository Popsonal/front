package com.example.popup_store

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.popup_store.databinding.ActivityMainBinding
//import com.example.popup_store.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 앱이 처음 실행되었을 때 HomeFragment를 보여줌
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // 바인딩을 통해 UI 요소에 접근할 수 있음
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

                R.id.fragment_myPage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MyPageFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}

/*

        // Home 버튼 클릭 시 HomeViewFragment로 전환
        val homeButton: ImageButton? = findViewById(R.id.HomeImageButton)
        homeButton?.setOnClickListener {
            if (!isCurrentFragment(HomeViewFragment::class.java.simpleName)) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeViewFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

        // Map 버튼 클릭 시 MapViewFragment로 전환
        val mapButton: ImageButton? = findViewById(R.id.MapImageButton)
        mapButton?.setOnClickListener {
            if (!isCurrentFragment(MapViewFragment::class.java.simpleName)) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MapViewFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

        // Event 버튼 클릭 시 EventViewFragment로 전환
        val eventButton: ImageButton? = findViewById(R.id.EventImageButton)
        eventButton?.setOnClickListener {
            if (!isCurrentFragment(EventViewFragment::class.java.simpleName)) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, EventViewFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }

        // MyPage 버튼 클릭 시 MyPageViewFragment로 전환
        val myPageButton: ImageButton? = findViewById(R.id.MyPageImageButton)
        myPageButton?.setOnClickListener {
            if (!isCurrentFragment(MyPageViewFragment::class.java.simpleName)) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MyPageViewFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    // 현재 표시 중인 프래그먼트를 확인하는 함수
    private fun isCurrentFragment(fragmentTag: String): Boolean {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        return currentFragment != null && currentFragment::class.java.simpleName == fragmentTag
    }
}

// HomeFragment 클래스
class HomeViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}

// MapFragment 클래스
class MapViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }
}

// EventFragment 클래스
class EventViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }
}

// MyPageFragment 클래스
class MyPageViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }
}
*/
