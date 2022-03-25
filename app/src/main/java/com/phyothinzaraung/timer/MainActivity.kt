package com.phyothinzaraung.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val btnSplit = findViewById<AppCompatButton>(R.id.btnSplit)
        val btnStop = findViewById<AppCompatButton>(R.id.btnStop)

        val txtTimer = findViewById<AppCompatTextView>(R.id.txtTimer)

        var count = 0

        val timer = object: CountDownTimer(50000, 1000){
            override fun onTick(p0: Long) {
                txtTimer.text = count.toString()
                count++
            }

            override fun onFinish() {
                count = 0
            }

        }

        btnStart.setOnClickListener(View.OnClickListener {
            count = 0
            timer.start()
        })

        btnStop.setOnClickListener(View.OnClickListener {
            timer.cancel()
            txtTimer.text = "0"
        })

        btnSplit.setOnClickListener(View.OnClickListener {
            timer.cancel()
            txtTimer.text = count.toString()
        })
    }
}