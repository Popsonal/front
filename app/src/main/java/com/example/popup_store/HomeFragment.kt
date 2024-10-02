package com.example.popup_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_home.xml을 inflate하여 레이아웃을 반환
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}
