package com.example.service_demo

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.example.service_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceConnection: ServiceConnection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service : IBinder?) {
                val myName = if (service is MyService.MyBinder) {
                    service.service.getServiceName()
                } else {
                    ""
                }

                Log.d("huaaa", myName)
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                TODO("Not yet implemented")
            }
        }

        bindService(Intent(this, MyService::class.java), serviceConnection, BIND_AUTO_CREATE)
    }
}