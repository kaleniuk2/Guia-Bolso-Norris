package com.kaleniuk2.guiabolsonorris.util

import java.text.SimpleDateFormat

object DateHelper {
    fun convertDateEuaToBr(date: String): String {
        var sdf = SimpleDateFormat("yyyy-MM-dd")
        val date = sdf.parse(date)
        sdf = SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(date)
    }
}