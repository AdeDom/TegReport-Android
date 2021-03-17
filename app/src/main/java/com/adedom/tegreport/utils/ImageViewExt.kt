package com.adedom.tegreport.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.adedom.tegreport.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadCircle(
    url: String?,
    @DrawableRes placeholder: Int = R.drawable.ic_image_profile
) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(placeholder))
        .circleCrop()
        .into(this)
}
