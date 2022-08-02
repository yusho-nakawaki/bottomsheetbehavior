package com.example.bottomsheetbehavior.jetpack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class JetpackComposeActivity : AppCompatActivity() {

    companion object {
        private const val referer = "JETPACK_COMPOSE_ACTIVITY"

        @JvmStatic
        fun createIntent(context: Context) = Intent(context, JetpackComposeActivity::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposePage()
        }
    }
}