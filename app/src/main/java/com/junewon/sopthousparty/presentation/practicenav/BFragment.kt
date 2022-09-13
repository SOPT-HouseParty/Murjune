package com.junewon.sopthousparty.presentation.practicenav

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.databinding.FragmentBBinding
import com.junewon.sopthousparty.util.binding.BindingFragment

class BFragment : BindingFragment<FragmentBBinding>(R.layout.fragment_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickEvent()
    }

    private fun initClickEvent() {
        binding.btnNavigate.setOnClickListener {
            val action = BFragmentDirections.actionBFragmentToCFragment()
            findNavController().navigate(action)
        }
    }
}
