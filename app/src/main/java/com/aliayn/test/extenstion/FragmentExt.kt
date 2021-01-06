package com.aliayn.test.extenstion

import android.content.Intent
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import com.aliayn.test.helper.Constance

fun Fragment.showGalleryIntent() {
    val pictureActionIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    startActivityForResult(pictureActionIntent, Constance.GALLERY_PICTURE)
}
