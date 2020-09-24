package com.purewowstudio.notifications.notifications

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.purewowstudio.notifications.R

fun NotificationManager.createNotification(
    context: Context,
    title: String
) {

}

fun buildNotification(context: Context) {
    val builder = NotificationCompat.Builder(
        context,
        context.getString(R.string.notifications_channel_id)
    )
}