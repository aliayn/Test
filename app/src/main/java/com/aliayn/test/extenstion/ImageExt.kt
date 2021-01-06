package com.aliayn.test.extenstion

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso
import java.io.File

fun ImageView.loadImage(@DrawableRes resourceId: Int) {
    Picasso.get().load(resourceId).centerCrop().into(this)
}

fun ImageView.loadImage(uri: Uri) {
    Picasso.get().load(uri).centerCrop().into(this)
}

fun ImageView.loadImage(path: String) {
    Picasso.get().load(path).centerCrop().into(this)
}

fun ImageView.loadImage(file: File) {
    Picasso.get().load(file).centerCrop().into(this)
}