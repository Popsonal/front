package com.example.popup_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_map.xml을 inflate하여 레이아웃을 반환합니다.
        return inflater.inflate(R.layout.fragment_map, container, false)
    }
}
