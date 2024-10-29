package com.example.popup_store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.popup_store.databinding.FragmentDescriptionBinding

class PopupStoreDescriptionFragment : Fragment() {

    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // FragmentPopupStoreDescriptionBinding을 사용하여 레이아웃 인플레이트
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 예시: 텍스트 설정
        binding.popupStoreTitle.text = "팝업스토어 이름"
        binding.popupStoreDescription.text = "여기에 팝업스토어에 대한 상세 설명을 추가하세요."
        // 이미지를 설정하고자 한다면 추가할 수 있습니다.
        // binding.popupStoreImage.setImageResource(R.drawable.sample_banner_image)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
