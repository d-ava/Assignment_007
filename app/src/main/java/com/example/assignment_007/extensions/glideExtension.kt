package com.example.homework_013.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.assignment_007.R

fun ImageView.glideExtension(img: String?) {
    if (!img.isNullOrEmpty()) {
        Glide.with(context).load(img).error(R.drawable.ic_launcher_background)
            .into(this)

    } else setImageResource(R.drawable.ic_launcher_background)


}