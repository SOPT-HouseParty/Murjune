package com.junewon.sopthousparty.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MokdongData(
    val imageUrl: String,
    val name: String
) : Parcelable
