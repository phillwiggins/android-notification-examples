package com.purewowstudio.notifications.notifications

import android.app.Notification
import android.content.Context
import android.os.Build
import android.text.SpannableString
import android.text.SpannableStringBuilder
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import androidx.core.text.bold
import com.purewowstudio.notifications.R
import com.purewowstudio.notifications.data.Message
import com.purewowstudio.notifications.utils.getBitmapFromUrl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.Calendar

@Suppress("BlockingMethodInNonBlockingContext")
class NotificationManager(
    private val context: Context,
    private val scope: CoroutineScope
) {

    init {
        createNotificationChannels()
    }

    /* Simple Notification
    *
    * A very basic notification. A title, content text and an image.
    */
    fun fireSimpleNotification() = scope.launch {
        val notification = buildSimpleNotification(
            context,
            "Rover",
            "Hey, I'm hungry",
            getBitmapFromUrl(context, DOGGO_URL, isRounded = true)
        )

        sendNotification(1234, notification)
    }

    /* Large Image Notification
    * A large notification. This notification will shrink to title and content message only
    * if there is not enough space. Otherwise, this will be title and the large text
    */
    fun fireLargeImageNotification() = scope.launch {
        val notification = buildLargeNotification(
            context,
            "Rover",
            "Hey, I'm REALLY hungry",
            getBitmapFromUrl(context, DOGGO_URL)
        )

        sendNotification(1235, notification)
    }

    /* Big Text Notification
    * A large notification. This notification will shrink to title and content message only
    * if there is not enough space. Otherwise, this will be title and the large text
    */
    fun fireBigTextNotification() = scope.launch {
        val content = SpannableString.valueOf(
            SpannableStringBuilder()
                .bold { append("What's for dinner?") }
                .append("\n")
                .append("I can't believe you left without feeding me. I'm hungry. I found a skittle under the fridge but barking doesn't make it come to me.")
                .append("\n")
                .append("...")
                .append("\n")
                .append("P.S. I drank all the water in my bowl")
        )

        val notification = buildLargeTextNotification(
            context,
            "Rover",
            "You have a new message",
            getBitmapFromUrl(context, DOGGO_URL, isRounded = true),
            content
        )

        sendNotification(1236, notification)
    }

    /* Inbox Style
    * A large notification. This notification will shrink to title and content message only
    * if there is not enough space. Otherwise, this will be title and a list of single lines. The
    * maximum line count is 6
    */
    fun fireInboxNotification() = scope.launch {
        val messages = listOf(
            SpannableString.valueOf(
                SpannableStringBuilder()
                    .bold { append("You forgot about me again!") }
                    .append(" Why can't I come to work with you?")
            ),
            SpannableString.valueOf(
                SpannableStringBuilder()
                    .bold { append("Where was my pat?") }
                    .append(" Why can't I come to work with you?")
            )
        )

        val notification = buildInboxStyleNotification(
            context,
            "Rover",
            "${messages.size} New messages from Rover",
            messages
        )

        sendNotification(1237, notification)
    }

    /* Message Style
       * A large notification. This notification will shrink to title and content message only
       * if there is not enough space. Otherwise, this will be title and a list of single lines
       * in a messaging style
       */
    fun fireMessageStyleNotification() = scope.launch {
        val doggo = Person.Builder()
            .setName("Rover")
            .setBot(false)
            .setIcon(IconCompat.createWithBitmap(getBitmapFromUrl(context, DOGGO_URL)))
            .setImportant(true)
            .build()

        val messages = listOf(
            Message(
                "You forgot about me again!",
                Calendar.getInstance().timeInMillis,
                doggo
            ),
            Message(
                "Where was my pat?",
                Calendar.getInstance().timeInMillis,
                doggo
            )
        )

        val notification = buildMessagesNotification(
            context,
            "Rover",
            "${messages.size} New messages from Rover",
            messages
        )

        sendNotification(1238, notification)
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(
                context,
                context.getString(R.string.notifications_channel_id),
                context.getString(R.string.notifications_channel_name),
                context.getString(R.string.notifications_channel_description)
            )
        }
    }

    private fun sendNotification(id: Int, notification: Notification) {
        NotificationManagerCompat.from(context).notify(id, notification)
    }

    companion object {
        private const val DOGGO_URL =
            "https://images.unsplash.com/photo-1537151608828-ea2b11777ee8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=639&q=80"
    }
}
