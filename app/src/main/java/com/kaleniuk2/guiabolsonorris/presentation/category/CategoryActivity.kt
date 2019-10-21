package com.kaleniuk2.guiabolsonorris.presentation.category

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kaleniuk2.guiabolsonorris.R

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        fun onNewIntent(context: Context): Intent {
            return Intent(context, CategoryActivity::class.java)
        }
    }
}
