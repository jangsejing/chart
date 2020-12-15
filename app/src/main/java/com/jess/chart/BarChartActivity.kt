package com.jess.chart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jess.chart.databinding.BarChartActivityBinding

class BarChartActivity : AppCompatActivity() {

    private lateinit var binding: BarChartActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BarChartActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {

        }
    }
}