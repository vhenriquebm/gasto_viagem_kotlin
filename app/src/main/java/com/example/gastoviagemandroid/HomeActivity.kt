package com.example.gastoviagemandroid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gastoviagemandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureButton()
    }

    private fun configureButton() {
        binding.buttonCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editPrice.text.toString() != ""
                && binding.editDistance.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate() {
        if (isValid()) {
            val price = binding.editPrice.text.toString().toFloat()
            val distance = binding.editDistance.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            val totalString = "R$ ${"%.2f".format(totalValue)}"

            binding.textPriceValue.text = totalString
        } else {
            Toast.makeText(this, R.string.home_fill_all_fields, Toast.LENGTH_LONG).show()
        }
    }
}