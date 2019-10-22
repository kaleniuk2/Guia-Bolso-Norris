package com.kaleniuk2.guiabolsonorris.util

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), View {
    abstract fun onInject()
    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        onInject()
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}