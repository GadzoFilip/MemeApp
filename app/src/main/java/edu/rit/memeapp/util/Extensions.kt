package edu.rit.memeapp.util

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import edu.rit.memeapp.R

fun ImageView.loadUrl(url: String?, isCircleCrop: Boolean = false) {
    url?.let {
        this.load(it) {
            crossfade(true)
            placeholder(R.mipmap.ic_launcher)
            if(isCircleCrop) transformations(CircleCropTransformation())
        }
    }
}