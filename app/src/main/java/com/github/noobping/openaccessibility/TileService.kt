package com.github.noobping.openaccessibility

import android.app.PendingIntent
import android.content.Intent
import android.provider.Settings
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class TileService : TileService() {
    override fun onClick() {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        val pending: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        startActivityAndCollapse(pending)
    }

    override fun onTileAdded() {
        qsTile.label = getString(R.string.app_name)
        qsTile.subtitle = getString(R.string.description)
        qsTile.contentDescription = getString(R.string.description)
        qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }

    override fun onTileRemoved() {
        super.onTileRemoved()
        qsTile.state = Tile.STATE_UNAVAILABLE
        qsTile.updateTile()
    }

    override fun onStartListening() {
        qsTile.label = getString(R.string.app_name)
        qsTile.subtitle = getString(R.string.description)
        qsTile.contentDescription = getString(R.string.description)
        qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }
}