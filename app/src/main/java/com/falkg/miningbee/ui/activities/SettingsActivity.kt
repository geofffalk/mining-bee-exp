package com.falkg.miningbee.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.falkg.miningbee.R
import com.falkg.miningbee.extensions.DelegatesExt
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val VIDEO_PID = "videoPid"
        const val DEFAULT_PID = "p05p3k3v"
    }

    private var videoPid: String by DelegatesExt.preference(this, VIDEO_PID, DEFAULT_PID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        videoPidText.setText(videoPid)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        videoPid = videoPidText.text.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }
}