package com.purewowstudio.notifications.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import coil.transform.CircleCropTransformation

suspend fun getBitmapFromUrl(context: Context, url: String, isRounded: Boolean = false): Bitmap {
    val loader = ImageLoader(context)
    val request = ImageRequest.Builder(context)
        .data(url)
        .allowHardware(false)

    if (isRounded) request.transformations(listOf(CircleCropTransformation()))

    val result = (loader.execute(request.build()) as SuccessResult).drawable
    return (result as BitmapDrawable).bitmap
}
