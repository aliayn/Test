package com.aliayn.test.extenstion

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aliayn.test.helper.Constance

fun Fragment.showGalleryIntent() {
    val pictureActionIntent = Intent(
        Intent.ACTION_PICK,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    )
    startActivityForResult(pictureActionIntent, Constance.GALLERY_PICTURE)
}

fun Fragment.findNavController(): NavController =
    NavHostFragment.findNavController(this)

fun Fragment.navigate(@IdRes resId: Int, bundle: Bundle? = bundleOf()): Unit =
    findNavController().navigate(resId, bundle)
