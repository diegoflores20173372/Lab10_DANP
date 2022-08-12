package com.labs_danp.lab10_danp

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

const val KEY_N1_ARG = "n1"
const val KEY_N2_ARG = "n2"

const val KEY_RESULT = "result"

class SumTwoNumbers(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here
        val n1 = inputData.getInt(KEY_N1_ARG, 0)
        val n2 = inputData.getInt(KEY_N2_ARG, 0)
        val sum = sumNumbers(n1, n2)
        val output: Data = workDataOf(KEY_RESULT to sum)
        // Indicate whether the work finished successfully with the Result
        return Result.success(output)
    }

    private fun sumNumbers(n1: Int, n2: Int): Int {
        Log.e("SumTask", "Se está sumando los valores")
        return n1 + n2
    }
}