package com.junewon.sopthousparty.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.junewon.sopthousparty.R

@BindingAdapter("app:imageUrl")
fun ImageView.setImageUrl(imageUrl: String?) {
    load(imageUrl) {
        placeholder(R.drawable.ic_launcher_foreground)
        error(R.drawable.ic_error_24)
    }
}
