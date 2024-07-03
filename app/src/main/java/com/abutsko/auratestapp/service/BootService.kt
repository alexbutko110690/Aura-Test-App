package com.abutsko.auratestapp.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import com.abutsko.auratestapp.R
import com.abutsko.auratestapp.data.db.BootDb
import com.abutsko.auratestapp.repository.local.db.dao.BootDao
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.util.Date

class BootService : LifecycleService() {

    private val bootDao: BootDao by inject()

    override fun onCreate() {
        super.onCreate()
//        createNotificationChannel()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        lifecycleScope.launch {
            Log.d("onStartCommand: ", Date().toString())
            bootDao.insert(BootDb(date = Date()))
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        super.onBind(intent)
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelID = getString(R.string.push_notifications_channel_id)
            val name = getString(R.string.push_notifications_channel_name)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelID, name, importance)
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}