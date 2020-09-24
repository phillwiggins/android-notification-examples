package com.purewowstudio.notifications.notifications

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.purewowstudio.notifications.R

fun buildSimpleNotification(
    context: Context,
    title: String,
    content: String,
    intent: Intent? = null,
    channelId: String = context.getString(R.string.notifications_channel_id)
): Notification {

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle(title)
        .setContentText(content)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)

    if (intent != null) {
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            0
        )

        builder.setContentIntent(pendingIntent)
    }

    return builder.build()
}