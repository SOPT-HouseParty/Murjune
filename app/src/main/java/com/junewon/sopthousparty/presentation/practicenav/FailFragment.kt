package com.junewon.sopthousparty.presentation.practicenav

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.databinding.FragmentFailBinding
import com.junewon.sopthousparty.util.binding.BindingFragment

class FailFragment : BindingFragment<FragmentFailBinding>(R.layout.fragment_fail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickEvent()
    }

    private fun setClickEvent() {
        binding.btnRestart.setOnClickListener {
            val action = FailFragmentDirections.actionFailFragmentToFragmentB()
            findNavController().navigate(action)
        }
    }
}
