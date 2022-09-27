package com.junewon.sopthousparty.presentation.activity_fragment_lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.junewon.sopthousparty.R
import timber.log.Timber

class PracticeLifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_lifecycle)
        Timber.tag("fragment").i("Activity - onCreate() called")
        supportFragmentManager.commit {
            Timber.tag("fragment").i("replace FirstFragment")
            replace<FirstFragment>(R.id.fragment_container_practice)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Timber.tag("fragment").i("Activity - onRestart() Called")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("fragment").i("Activity - onStart() Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("fragment").i("Activity - onResume() Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("fragment").i("Activity - onPause() Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("fragment").i("Activity - onStop() Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("fragment").i("Activity - onDestroy() Called")
    }
}
