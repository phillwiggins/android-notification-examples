package com.purewowstudio.notifications.notifications

import android.app.Notification
import android.content.Context
import android.graphics.Bitmap
import android.text.SpannableString
import androidx.core.app.NotificationCompat
import com.purewowstudio.notifications.R

fun buildSimpleNotification(
    context: Context,
    title: String,
    content: String,
    image: Bitmap
): Notification = basicBuilder(context, title, content)
    .setLargeIcon(image)
    .build()

fun buildLargeNotification(
    context: Context,
    title: String,
    content: String,
    image: Bitmap
): Notification = basicBuilder(context, title, content)
    .setLargeIcon(image)
    .setStyle(
        NotificationCompat.BigPictureStyle()
            .bigPicture(image)
            .bigLargeIcon(null)
    )
    .build()

fun buildLargeTextNotification(
    context: Context,
    title: String,
    content: String,
    image: Bitmap,
    largeText: SpannableString
): Notification = basicBuilder(context, title, content)
    .setLargeIcon(image)
    .setStyle(
        NotificationCompat.BigTextStyle()
            .bigText(largeText)
    )
    .build()

fun buildInboxStyleNotification(
    context: Context,
    title: String,
    content: String,
    messages: List<SpannableString>
): Notification {
    val style = NotificationCompat.InboxStyle()
    for (message in messages) {
        style.addLine(message)
    }
    return basicBuilder(context, title, content)
        .setStyle(style)
        .build()
}

private fun basicBuilder(
    context: Context,
    title: String,
    content: String
): NotificationCompat.Builder {
    return NotificationCompat.Builder(context, context.getString(R.string.notifications_channel_id))
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle(title)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setAutoCancel(true)
        .setContentText(content)
}
