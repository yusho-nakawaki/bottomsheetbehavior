package com.example.bottomsheetbehavior.jetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JetpackComposePage() {
    Column(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        for (i in 1..10) {
            Text(
                text = "アイウエオ: " + i.toString(),
                 modifier = Modifier.padding(10.dp),
                style = TextStyle(fontSize = 20.sp)
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}