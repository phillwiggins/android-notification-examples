package com.purewowstudio.notifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().apply {
            add(
                R.id.fragment_container,
                FirstFragment.newInstance()
            )
            commit()
        }
    }
}
