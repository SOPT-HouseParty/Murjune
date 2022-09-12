package com.junewon.sopthousparty.presentation.type

import androidx.annotation.DrawableRes
import com.junewon.sopthousparty.R

enum class DiceType(val number: String, @DrawableRes val res: Int) {
    EMPTY_DICE("EMPTY", R.drawable.empty_dice),
    DICE_ONE("1", R.drawable.dice_1),
    DICE_TWO("2", R.drawable.dice_2),
    DICE_THREE("3", R.drawable.dice_3),
    DICE_FOUR("4", R.drawable.dice_4),
    DICE_FIVE("5", R.drawable.dice_5),
    DICE_SIX("6", R.drawable.dice_6),
}
