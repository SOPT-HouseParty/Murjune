package com.junewon.sopthousparty.presentation.practicenav

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.databinding.FragmentSuccessBinding
import com.junewon.sopthousparty.util.binding.BindingFragment
import timber.log.Timber

class SuccessFragment : BindingFragment<FragmentSuccessBinding>(R.layout.fragment_success) {
    private val args by navArgs<SuccessFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.data = args.mokdongData
        setClickEvent()
    }

    private fun setClickEvent() {
        binding.btnBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed() // api 33부터 activity?.onBackPressed()가 안됨
        }
    }
}
