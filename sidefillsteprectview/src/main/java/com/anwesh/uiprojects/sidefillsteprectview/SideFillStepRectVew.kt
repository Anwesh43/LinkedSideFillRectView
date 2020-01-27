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
