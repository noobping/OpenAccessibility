package com.github.noobping.openaccessibility

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openAccessibilitySettings()
        finishAffinity()
    }

    private fun openAccessibilitySettings() {
        val selectToSpeakIntent = Intent().apply {
            component = ComponentName(
                "com.android.settings",
                "com.android.settings.accessibility.AccessibilitySettings\$SelectToSpeakSettingsActivity"
            )
        }

        try {
            startActivity(selectToSpeakIntent)
        } catch (e: ActivityNotFoundException) {
            val accessibilityIntent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(accessibilityIntent)
        }
    }
}
