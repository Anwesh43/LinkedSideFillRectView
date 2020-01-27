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
