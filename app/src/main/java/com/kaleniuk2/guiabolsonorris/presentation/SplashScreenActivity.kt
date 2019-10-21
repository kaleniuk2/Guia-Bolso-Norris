package com.kaleniuk2.guiabolsonorris.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.kaleniuk2.guiabolsonorris.R
import com.kaleniuk2.guiabolsonorris.presentation.category.CategoryActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashScreenActivity : AppCompatActivity() {
    private val mHideHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_splash_screen)

        startNextActivity()
    }

    private fun startNextActivity() {
        mHideHandler.postDelayed({
            startActivity(CategoryActivity.onNewIntent(this))
            finish()
        }, ANIMATION_DELAY)
    }

    companion object {
        const val ANIMATION_DELAY = 2000L
    }
}
