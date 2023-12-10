package com.dena.auto.taxi.backseat.goatbooking

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.flash.FlashScreen
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.home.HomeScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            FlashScreen(navController = navController)
        }
        composable("home_screen") {
            HomeScreen()
        }
    }
}