package com.labs_danp.lab10_danp

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SessionStarted(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here
        login()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun login() {
        Log.e("Task#3", "Tarea de Inicio de Sesion")
    }
}