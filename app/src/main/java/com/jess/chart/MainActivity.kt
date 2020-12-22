package com.jess.chart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jess.chart.circle.CircleChartActivity
import com.jess.chart.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btBar.setOnClickListener {
                startActivity(Intent(this@MainActivity, BarChartActivity::class.java))
            }
        }

        startActivity(Intent(this@MainActivity, CircleChartActivity::class.java))
    }
}