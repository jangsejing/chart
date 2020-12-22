package com.jess.chart.circle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jess.chart.databinding.CircleChartActivityBinding
import com.jess.chart.databinding.MainActivityBinding
import com.jess.chart.line.LineChartActivity

class CircleChartActivity : AppCompatActivity() {

    private lateinit var binding: CircleChartActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CircleChartActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}