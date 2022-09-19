package com.junewon.sopthousparty.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("app:imageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    if (imageUrl == null || imageUrl == "") return
    load(imageUrl)
}
