package com.labs_danp.lab10_danp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnParameters: Button = findViewById(R.id.btnParametersButton)
        btnParameters.setOnClickListener {
            val number1: EditText = findViewById(R.id.edtNumber1)
            val n1: Int = number1.text.toString().toInt()
            val number2: EditText = findViewById(R.id.edtNumber2)
            val n2: Int = number2.text.toString().toInt()
            val data: Data = workDataOf(KEY_N1_ARG to n1, KEY_N2_ARG to n2)
            val sumTwoNumbersWork = OneTimeWorkRequestBuilder<SumTwoNumbers>()
                .setInputData(data)
                .build()
            WorkManager.getInstance(this)
                .enqueue(sumTwoNumbersWork)
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(sumTwoNumbersWork.id)
                .observe(this, Observer { info ->
                    if (info != null && info.state.isFinished) {
                        val myResult = info.outputData.getInt(KEY_RESULT, 0)
                        Toast.makeText(
                            this,
                            "La suma de los números es: $myResult",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }

        val btnSequential: Button = findViewById(R.id.btnSequentialTask)
        btnSequential.setOnClickListener {
            val loadLoginWork: OneTimeWorkRequest = OneTimeWorkRequestBuilder<LoadingLogin>()
                .build()
            val validateLoginWork: OneTimeWorkRequest = OneTimeWorkRequestBuilder<ValidateLogin>()
                .build()
            val sessionStartedWork: OneTimeWorkRequest = OneTimeWorkRequestBuilder<SessionStarted>()
                .build()

            WorkManager.getInstance(this)
                .beginWith(loadLoginWork)
                .then(validateLoginWork)
                .then(sessionStartedWork)
                .enqueue()
        }

        val btnParallel: Button = findViewById(R.id.btnParallelTask)
        btnParallel.setOnClickListener {
            val loadLoginWork: OneTimeWorkRequest = OneTimeWorkRequestBuilder<LoadingLogin>()
                .build()
            val validateLoginWork: OneTimeWorkRequest = OneTimeWorkRequestBuilder<ValidateLogin>()
                .build()
            val sessionStartedWork: OneTimeWorkRequest = OneTimeWorkRequestBuilder<SessionStarted>()
                .build()

            WorkManager.getInstance(this)
                .beginWith(listOf(loadLoginWork, validateLoginWork))
                .then(sessionStartedWork)
                .enqueue()
        }

    }

}