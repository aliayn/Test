package com.aliayn.test.extenstion

import android.net.Uri
import android.widget.ImageView
import com.aliayn.test.R
import com.aliayn.test.helper.CircleTransform
import com.squareup.picasso.Picasso

fun ImageView.loadImage(uri: Uri) =
    Picasso.get().load(uri).transform(CircleTransform())
        .placeholder(R.drawable.ic_avatar).into(this)

fun ImageView.loadImage(path: String) =
    Picasso.get().load(Uri.parse(path)).transform(CircleTransform())
        .placeholder(R.drawable.ic_avatar).into(this)
