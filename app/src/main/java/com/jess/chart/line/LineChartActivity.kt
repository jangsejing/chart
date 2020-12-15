package com.jess.chart.line

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.jess.chart.R
import com.jess.chart.databinding.LineChartActivityBinding
import com.jess.chart.util.dpToPx


class LineChartActivity : AppCompatActivity() {

    private lateinit var binding: LineChartActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LineChartActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {

            val entries = ArrayList<Entry>().apply {
                add(Entry(-1f, 80f))
                add(Entry(1f, 100f))
                add(Entry(2f, 50f))
                add(Entry(3f, 30f))
                add(Entry(4f, 200f))
                add(Entry(5f, 100f).apply {
                    icon = ResourcesCompat.getDrawable(resources, R.drawable.shp_ovel_red_3dp, null)
                })
            }

            val lineDataSet = LineDataSet(entries, null).apply {

                // 값 표시
                setDrawValues(false)

                // entry icon 표시
                setDrawIcons(true)

                // 선
                lineWidth = 2f // 선 굵기
                color = ContextCompat.getColor(
                    this@LineChartActivity,
                    R.color.black
                )

                // 원
                setDrawCircles(false) // 원 비활성화

                // 배경
                setDrawFilled(true)
                fillDrawable =
                    ContextCompat.getDrawable(
                        this@LineChartActivity,
                        R.drawable.shp_gradient_red
                    )

                setDrawHighlightIndicators(false)

            }

            val lineData = LineData().apply {
                addDataSet(lineDataSet)
            }

            chart.run {

                // 범주
                legend.isEnabled = false

                // 우측 하단
                description.isEnabled = false

                // x축
                chart.xAxis.run {
                    setDrawGridLines(false)
                    setDrawAxisLine(false)
                    position = XAxis.XAxisPosition.BOTTOM_INSIDE
                    granularity = 1f
                    labelCount = 10
                    valueFormatter = object : ValueFormatter() {
                        override fun getFormattedValue(value: Float): String {
                            return if (value < 0) {
                                ""
                            } else {
                                "%d월".format(value.toInt())
                            }
                        }
                    }

                    // 값 컬러
                    textColor = ContextCompat.getColor(
                        this@LineChartActivity,
                        R.color.purple_200
                    )
                    // 사이즈
                    textSize = 11f

                    extraRightOffset = 0f;
                    extraLeftOffset = 0f;

                    setPadding(0, 0, 0, 100)
                }

                // y축 왼쪽 라인, 라벨, 그리드
                chart.axisLeft.let {
                    it.setDrawGridLines(false)
                    it.setDrawLabels(false)
                    it.setDrawAxisLine(false)
                }

                // y축 오른쪽 라인, 라벨, 그리드
                chart.axisRight.let {
                    it.setDrawGridLines(false)
                    it.setDrawLabels(false)
                    it.setDrawAxisLine(false)
                }

                setScaleEnabled(false)
                setPinchZoom(false)
                data = lineData


                chart.setViewPortOffsets(0f, 0f, 50.dpToPx(this@LineChartActivity).toFloat(), 0f);
                post {
                    binding.chart.invalidate()
                }
            }
        }
    }
}