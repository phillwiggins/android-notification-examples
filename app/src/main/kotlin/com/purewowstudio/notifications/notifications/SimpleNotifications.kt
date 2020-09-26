package com.purewowstudio.notifications.notifications

import com.purewowstudio.notifications.data.NotificationListItem

fun getSimpleNotifications(notificationManager: NotificationManager) = listOf(
    NotificationListItem(
        "Simple",
        "A basic notification containing a title and content with a small image."
    ) { notificationManager.fireSimpleNotification() },
    NotificationListItem(
        "Large Image",
        "A notification that contains a large image with a small content text."
    ) { notificationManager.fireLargeImageNotification() },
    NotificationListItem(
        "Large Text",
        "A large notification that can contain multiline text. This text can be formatted using SpannableStrings or HTML."
    ) { notificationManager.fireBigTextNotification() },
    NotificationListItem(
        "Inbox Style",
        "A multiline notification that can be useful for displaying a list of items. Can accept Spannables. Suitable for an Inbox"
    ) { notificationManager.fireInboxNotification() },
    NotificationListItem(
        "Message Style",
        "A multiline notification that can be useful for displaying a list of items. Can accept Spannables. Suitable for muliple messages from a contact"
    ) { notificationManager.fireMessageStyleNotification() }
)
