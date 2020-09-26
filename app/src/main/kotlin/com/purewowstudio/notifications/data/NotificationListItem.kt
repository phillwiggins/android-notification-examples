package com.purewowstudio.notifications.data

data class NotificationListItem(
    val title: String,
    val description: String,
    val action: () -> Unit
)
