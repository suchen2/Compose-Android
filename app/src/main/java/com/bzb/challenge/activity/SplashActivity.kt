package com.bzb.challenge.activity

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import com.bzb.challenge.databinding.ActivitySplashBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 1000)
    }

}