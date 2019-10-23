package com.kaleniuk2.guiabolsonorris.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar_main.*

abstract class BaseActivity : AppCompatActivity(), View {
    abstract fun onInject()
    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setSupportActionBar(toolbar_main)
        onInject()
    }
}