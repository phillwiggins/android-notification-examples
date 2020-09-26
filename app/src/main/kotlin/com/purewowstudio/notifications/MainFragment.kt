package com.purewowstudio.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.purewowstudio.notifications.databinding.FragmentMainBinding
import com.purewowstudio.notifications.notifications.NotificationManager
import com.purewowstudio.notifications.notifications.getSimpleNotifications

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var notificationManager: NotificationManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        createNotificationManager()
        renderUI()
    }

    private fun createNotificationManager() {
        notificationManager = NotificationManager(
            requireContext(),
            lifecycleScope
        )
    }

    private fun renderUI() {
        binding.listSimple.layoutManager = LinearLayoutManager(requireContext())
        binding.listSimple.adapter = NotificationAdapter(getSimpleNotifications(notificationManager))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
