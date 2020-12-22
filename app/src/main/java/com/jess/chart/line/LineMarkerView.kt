package com.jess.chart.line

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF


@SuppressLint("ViewConstructor")
class LineMarkerView(context: Context?, layoutResource: Int) : MarkerView(context, layoutResource) {

    override fun draw(canvas: Canvas?) {
//        canvas?.let {
//            it.translate((width / 2).toFloat(), -height.toFloat())
//        }
        super.draw(canvas)
    }

//    override fun getOffset(): MPPointF? {
//        return MPPointF((-(width / 100)).toFloat(), (-height).toFloat())
//    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
    }

}