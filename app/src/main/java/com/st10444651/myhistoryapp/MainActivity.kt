package com.st10444651.myhistoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnCompare: Button
    private lateinit var btnClear: Button
    private lateinit var etAge: EditText
    private lateinit var resultTV: TextView
    private lateinit var nameTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCompare = findViewById<Button>(R.id.btnCompare)
        btnClear = findViewById<Button>(R.id.btnClear)
        etAge = findViewById<EditText>(R.id.etAge)
        resultTV = findViewById<TextView>(R.id.resultTV)
        nameTV = findViewById<TextView>(R.id.nameTV)

        btnCompare.setOnClickListener {
            val userAge = etAge.text.toString().toIntOrNull()
            Log.v("History App", "user input: $userAge")
            if (userAge == null) {
                resultTV.text = "Please enter a valid age. It must be a whole number without any decimals or text"
            } else {
                if (userAge <= 12 || userAge > 100) {
                    resultTV.text = "Please enter an age between 12 and 100."
                    etAge.text.clear()
                } else {
                    val result = when (userAge) {
                        12 -> "Hector Pieterson died at this age"
                        25 -> "Tupac Shakur died at this age"
                        30 -> "Steve Biko died at this age"
                        60 -> "Diego Maradona died at this age"
                        75 -> "Oliver Tambo died at this age"
                        78 -> "Hugh Masekela died at this age"
                        81 -> "Winnie Mandela died at this age"
                        82 -> "Pele died at this age"
                        90 -> "Desmond Tutu died at this age"
                        96 -> "Elizabeth II died at this age"
                        else -> "Nobody known in this app died at this age"
                    }
                    resultTV.text = result
                }
            }
        }
        btnClear.setOnClickListener {
            etAge.text.clear()
            resultTV.text = ""
        }
    }
}
