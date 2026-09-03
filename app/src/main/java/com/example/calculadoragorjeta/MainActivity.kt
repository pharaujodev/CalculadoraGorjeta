package com.example.calculadoragorjeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.calculadoragorjeta.navigation.AppNavGraph
import com.example.calculadoragorjeta.ui.theme.CalculadoraGorjetaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraGorjetaTheme {
                AppNavGraph()
            }
        }
    }
}
