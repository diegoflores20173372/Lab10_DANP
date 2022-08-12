package com.labs_danp.lab10_danp

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class LoadingLogin(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here
        loadLogin()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun loadLogin() {
        Log.e("Task#1", "Tarea de Carga de Login")
    }
}