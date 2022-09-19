package com.junewon.sopthousparty.presentation.dice

import androidx.lifecycle.ViewModel
import com.junewon.sopthousparty.presentation.type.DiceType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*

class DiceViewModel : ViewModel() {
    private var _currentDice = MutableStateFlow<DiceType>(DiceType.EMPTY_DICE)
    val currentDice: StateFlow<DiceType> = _currentDice.asStateFlow()
    fun setDiceNum() {
        val diceNum = Random().nextInt(6) + 1
        _currentDice.value = when (diceNum) {
            1 -> DiceType.DICE_ONE
            2 -> DiceType.DICE_TWO
            3 -> DiceType.DICE_THREE
            4 -> DiceType.DICE_FOUR
            5 -> DiceType.DICE_FIVE
            6 -> DiceType.DICE_SIX
            else -> DiceType.EMPTY_DICE
        }
    }
}
