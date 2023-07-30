package com.example.service_demo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val binder = MyBinder()

    override fun onCreate() {
        super.onCreate()
        Log.d("huaaa", "create")
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    fun getServiceName(): String {
        return MyService::class.java.name
    }

    inner class MyBinder : Binder() {

        val service: MyService get() = this@MyService
    }
}