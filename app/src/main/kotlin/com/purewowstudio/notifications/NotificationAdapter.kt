package com.purewowstudio.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.purewowstudio.notifications.data.NotificationListItem
import com.purewowstudio.notifications.databinding.ItemNotificationBinding

class NotificationAdapter(private val data: List<NotificationListItem>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemBinding =
            ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class NotificationViewHolder(val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NotificationListItem) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.root.setOnClickListener { item.action.invoke() }
        }
    }
}
