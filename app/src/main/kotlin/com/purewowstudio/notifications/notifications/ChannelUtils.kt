package com.purewowstudio.notifications.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
fun createNotificationChannel(
    context: Context,
    channelId: String,
    channelName: String,
    channelDescription: String,
    importance: Int = NotificationManager.IMPORTANCE_DEFAULT,
    enableLights: Boolean = true,
    lightColor: Int = Color.RED,
    enableVibration: Boolean = true
) {
    val notificationChannel = NotificationChannel(
        channelId,
        channelName,
        importance
    )

    notificationChannel.enableLights(enableLights)
    notificationChannel.lightColor = lightColor
    notificationChannel.enableVibration(enableVibration)
    notificationChannel.description = channelDescription

    val notificationManager = context.getSystemService(
        NotificationManager::class.java
    )

    notificationManager.createNotificationChannel(notificationChannel)
}
