package com.example.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculate() }
    }

    private fun calculate() {
        val stringInTextField = binding.IHaveAHryvnia.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.result.text = ""
            return
        }

        val costPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_zero_two_four_four -> 0.0244
            else -> 0.025
        }

        var result = costPercentage * cost

        val formattedResult = NumberFormat.getCurrencyInstance().format(result)
        binding.result.text = getString(R.string.result, formattedResult)
    }
}