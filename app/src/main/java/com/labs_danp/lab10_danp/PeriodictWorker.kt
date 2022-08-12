package com.labs_danp.lab10_danp

import android.content.Context
import android.util.Log
import android.widget.Toast

import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class PeriodictWorker (context: Context, params: WorkerParameters) : Worker(context, params){
    override fun doWork(): Result {
        try {

            for (i in 0..10) {
                Log.i("Tag", "Contador $i")
            }
            val hora = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val horac = hora.format(Date())
            Log.i("Tag", "Hora de impresion: $horac")
            //Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
            return Result.success()
        } catch( e: Exception){
            return Result.failure()
        }
    }
}