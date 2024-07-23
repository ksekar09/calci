package com.example.calci

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1: EditText = findViewById(R.id.number1)
        val number2: EditText = findViewById(R.id.number2)
        val result: TextView = findViewById(R.id.result)

        findViewById<Button>(R.id.button_add).setOnClickListener {
            performOperation(number1, number2, result, "add")
        }

        findViewById<Button>(R.id.button_subtract).setOnClickListener {
            performOperation(number1, number2, result, "subtract")
        }

        findViewById<Button>(R.id.button_multiply).setOnClickListener {
            performOperation(number1, number2, result, "multiply")
        }

        findViewById<Button>(R.id.button_divide).setOnClickListener {
            performOperation(number1, number2, result, "divide")
        }
    }

    private fun performOperation(number1: EditText, number2: EditText, result: TextView, operation: String) {
        val num1 = number1.text.toString().toDoubleOrNull()
        val num2 = number2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            result.text = "Invalid input"
            return
        }

        val resultText = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> {
                if (num2 == 0.0) {
                    "Cannot divide by zero"
                } else {
                    num1 / num2
                }
            }
            else -> "Invalid operation"
        }

        result.text = resultText.toString()
    }
}
