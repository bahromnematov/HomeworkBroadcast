package uz.gita.homeworkbroadcast

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import uz.gita.homeworkbroadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var myReciever:MyReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myReciever= MyReceiver()
        val intentFilter=IntentFilter()
        intentFilter.addAction(Intent.ACTION_SCREEN_ON)
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF)
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(myReciever, intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReciever)
    }
}