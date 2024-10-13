package com.example.popup_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.popup_store.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {

    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 스크랩 항목 클릭 시 세부 내용 토글
        binding.scrapSection.setOnClickListener {
            toggleVisibility(binding.scrapDetails)
        }

        // 리뷰 항목 클릭 시 세부 내용 토글
        binding.reviewSection.setOnClickListener {
            toggleVisibility(binding.reviewDetails)
        }

        // 예약 항목 클릭 시 세부 내용 토글
        binding.bookingSection.setOnClickListener {
            toggleVisibility(binding.bookingDetails)
        }
    }

    private fun toggleVisibility(view: View) {
        if (view.visibility == View.VISIBLE) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}