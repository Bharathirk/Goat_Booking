package com.dena.auto.taxi.backseat.goatbooking

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.MainScreen
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.home.BookScreen
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.home.HistoryScreen
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.home.HomeScreen
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.splash.SplashScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("Main_screen") {
            MainScreen()
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen()
        }
        composable("book_screen") {
            BookScreen()
        }
        composable("history_screen") {
            HistoryScreen()
        }
    }
}