package com.junewon.sopthousparty.presentation.dice

import android.os.Bundle
import androidx.activity.viewModels
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.databinding.ActivityDiceBinding
import com.junewon.sopthousparty.util.binding.BindingActivity

class DiceActivity : BindingActivity<ActivityDiceBinding>(R.layout.activity_dice) {
    private val viewModel by viewModels<DiceViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
    }
}
