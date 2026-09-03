package com.example.calculadoragorjeta.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculadoragorjeta.ui.screens.GorjetaScreen
import com.example.calculadoragorjeta.ui.screens.MenuScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Menu){
        composable <Menu> {
            MenuScreen (
                aoAbrirGorjeta = {
                    navController.navigate(Gorjeta)
                }
            )
        }
        composable <Gorjeta> {
            GorjetaScreen()
        }
    }
}