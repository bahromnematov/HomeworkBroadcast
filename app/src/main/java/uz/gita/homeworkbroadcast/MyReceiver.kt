package uz.gita.homeworkbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log

class MyReceiver:BroadcastReceiver(){
    private lateinit var mediaPlayerOF: MediaPlayer
    private lateinit var mediaPlayerON:MediaPlayer
    private lateinit var mediaPlayerChangerOn:MediaPlayer
    private lateinit var mediaPlayerChangerOFF:MediaPlayer


    override fun onReceive(p0: Context?, intent: Intent?) {
        mediaPlayerON=MediaPlayer.create(p0,R.raw.swichton)
        mediaPlayerOF=MediaPlayer.create(p0,R.raw.switchoff)
        mediaPlayerChangerOn=MediaPlayer.create(p0,R.raw.chargersuc)
        mediaPlayerChangerOFF=MediaPlayer.create(p0,R.raw.chargerdis)
        if (intent?.action.equals(Intent.ACTION_SCREEN_ON)) {
            mediaPlayerON.start()
        }
        if (intent?.action.equals(Intent.ACTION_SCREEN_OFF)) {
            mediaPlayerOF.start()
        }
        if (intent?.action.equals(Intent.ACTION_POWER_CONNECTED)) {
            mediaPlayerChangerOn.start()
        }
        if (intent?.action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            mediaPlayerChangerOFF.start()
        }

    }

}