package com.labs_danp.lab10_danp

import android.content.Context
import android.util.Log
import android.widget.Toast

import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class UploadWorker (context: Context, params:WorkerParameters) : Worker(context, params){
    override fun doWork(): Result {
        try {
            for (i in 0..10) {
                Log.i("Tag", "Contador $i")
            }
            val msg="Funcion cultimanda una vez"
            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
            return Result.success()
        } catch( e:Exception){
            return Result.failure()
        }
    }
}