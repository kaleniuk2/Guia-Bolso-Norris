package com.kaleniuk2.guiabolsonorris.util

import android.content.Context
import android.widget.Toast

object ToastHelper {
    fun show(context: Context, phrase: String) = Toast.makeText(context, phrase, Toast.LENGTH_SHORT).show()
}