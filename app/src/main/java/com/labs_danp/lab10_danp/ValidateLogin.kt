package com.labs_danp.lab10_danp

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class ValidateLogin(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here
        validateLogin()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun validateLogin() {
        Log.e("Task#2", "Tarea de Validación de Login")
    }
}