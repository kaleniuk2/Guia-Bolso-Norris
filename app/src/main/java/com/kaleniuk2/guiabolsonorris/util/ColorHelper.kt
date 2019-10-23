package com.kaleniuk2.guiabolsonorris.util

import android.graphics.Color
import java.util.*

object ColorHelper {

    fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}