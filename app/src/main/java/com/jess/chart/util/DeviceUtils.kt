package com.jess.chart.util

import android.content.Context
import android.util.TypedValue

inline fun Int.dpToPx(context: Context): Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    toFloat(),
    context.resources.displayMetrics
).toInt()