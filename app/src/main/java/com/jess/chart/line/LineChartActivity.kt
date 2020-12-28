package com.jess.chart.line

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.github.mikephil.charting.animation.Easing
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
            setDrawValues(false) // 값 표시
            setDrawIcons(true) // entry icon 표시
            setDrawCircles(false) // 원 비활성화
            setDrawFilled(true) // 배경
            setDrawHighlightIndicators(false)

            lineWidth = 2f // 선 굵기
            color = ContextCompat.getColor(
                this@LineChartActivity,
                R.color.black
            )
            fillDrawable =
                ContextCompat.getDrawable(
                    this@LineChartActivity,
                    R.drawable.shp_gradient_red
                )
            mode = LineDataSet.Mode.LINEAR
        }

        val lineData = LineData().apply {
            addDataSet(lineDataSet)
        }

        with(binding.chart) {
            legend.isEnabled = false // 범주
            description.isEnabled = false // 우측 하단
            isAutoScaleMinMaxEnabled = true
            isDoubleTapToZoomEnabled = false
            isDragEnabled = false
            setPinchZoom(false)
            setDrawGridBackground(false)
            setTouchEnabled(false)
            setScaleEnabled(false)

            // x축
            with(xAxis) {
                setDrawGridLines(false)
                setDrawAxisLine(false)
                setScaleEnabled(false)
                setPinchZoom(false)
                setTouchEnabled(true)
                setPadding(0, 0, 0, 100)

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
            }

            // y축 왼쪽 라인, 라벨, 그리드
            with(axisLeft) {
                isEnabled = false
            }

            // y축 오른쪽 라인, 라벨, 그리드
            with(axisRight) {
                isEnabled = false
            }

            data = lineData

            setViewPortOffsets(0f, 0f, 50.dpToPx(this@LineChartActivity).toFloat(), 0f);
            post {
                binding.chart.invalidate()
            }
        }
    }
}