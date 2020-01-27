package com.anwesh.uiprojects.sidefillsteprectview

/**
 * Created by anweshmishra on 27/01/20.
 */

import android.content.Context
import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.graphics.RectF
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path

val nodes : Int = 5
val circles : Int  = 5
val rFactor : Float = 3f
val fillColor : Int = Color.parseColor("#3F51B5")
val staticColor : Int = Color.parseColor("#757575")
val backColor : Int = Color.parseColor("#BDBDBD")
val delay : Long = 20
val scGap : Float = 0.02f / circles

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawStepFillCircle(i : Int, scale : Float, w : Float, paint : Paint) {
    val gap : Float = w / (circles)
    val sf : Float = scale.sinify().divideScale(i, circles)
    val r : Float = gap / rFactor
    save()
    translate(gap * i + r, 0f)
    paint.color = staticColor
    drawCircle(0f, 0f, r, paint)
    save()
    paint.color = fillColor
    val path : Path = Path()
    path.addCircle(0f, 0f, r, Path.Direction.CW)
    clipPath(path)
    drawRect(RectF(-r, -r, -r + 2 * r * sf, r), paint)
    restore()
    restore()
}

fun Canvas.drawStepFillCircles(scale : Float, w : Float, paint : Paint) {
    for (j in 0..(circles - 1)) {
        drawStepFillCircle(j, scale, w, paint)
    }
}

fun Canvas.drawSFCNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val hGap : Float = h / (nodes + 1)
    save()
    translate(0f, hGap * (i + 1))
    drawStepFillCircles(scale, w, paint)
    restore()
}
