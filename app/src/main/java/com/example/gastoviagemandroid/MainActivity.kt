package com.example.gastoviagemandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.gastoviagemandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureButton()
    }

    private fun configureButton() {
        binding.buttonCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val price = binding.editPrice.text.toString().toFloat()
        val distance = binding.editDistance.text.toString().toFloat()
        val autonomy = binding.editAutonomy.text.toString().toFloat()

        val totalValue = (distance * price) / autonomy
        val totalString = "R$ ${"%.2f".format(totalValue)}"

        binding.textPriceValue.text = totalString
    }
}