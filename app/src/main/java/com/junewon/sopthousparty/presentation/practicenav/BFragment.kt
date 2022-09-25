package com.junewon.sopthousparty.presentation.practicenav

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.data.model.MokdongData
import com.junewon.sopthousparty.databinding.FragmentBBinding
import com.junewon.sopthousparty.util.binding.BindingFragment

class BFragment : BindingFragment<FragmentBBinding>(R.layout.fragment_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickEvent()
    }

    private fun initClickEvent() {
        binding.btnMokdong.setOnClickListener {
            val action = BFragmentDirections.actionFragmentBToSuccessFragment(
                MokdongData(
                    "https://user-images.githubusercontent.com/87055456/191024885-a14f5deb-7f85-4bf8-96a4-21c2fe9e4c04.png",
                    "목동"
                )
            )
            findNavController().navigate(action)
        }
        binding.btnSindorim.setOnClickListener {
            val action = BFragmentDirections.actionFragmentBToFailFragment()
            findNavController().navigate(action)
        }
    }
}
