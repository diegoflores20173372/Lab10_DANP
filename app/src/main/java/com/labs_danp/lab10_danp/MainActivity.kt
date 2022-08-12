package com.labs_danp.lab10_danp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            setOneTimeWorkRequest()
        }

        buttonPeriodic.setOnClickListener{
            setPeriodicTimeWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest(){
        val uploafRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).build()
        WorkManager.getInstance(applicationContext).enqueue(uploafRequest)
    }

    private fun setPeriodicTimeWorkRequest(){
        val periodictRequest = PeriodicWorkRequest.Builder(PeriodictWorker::class.java,
            1,TimeUnit.MINUTES).build()

        WorkManager.getInstance(applicationContext).enqueue(periodictRequest)
    }
}