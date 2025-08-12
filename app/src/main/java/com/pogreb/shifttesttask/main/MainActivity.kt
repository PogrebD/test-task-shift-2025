package com.pogreb.shifttesttask.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pogreb.shifttesttask.main.ui.MainScreen
import com.pogreb.shifttesttask.ui.theme.ShiftTestTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShiftTestTaskTheme {
                MainScreen()
            }
        }
    }
}