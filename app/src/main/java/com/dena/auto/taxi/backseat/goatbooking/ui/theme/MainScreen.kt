package com.dena.auto.taxi.backseat.goatbooking.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.dena.auto.taxi.backseat.goatbooking.BottomNavigation
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.bottom_bar.BottomNavItem
import com.dena.auto.taxi.backseat.goatbooking.ui.theme.bottom_bar.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        route = "home_screen",
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        hasNews = false
                    ),
                    BottomNavItem(
                        route = "book_screen",
                        title = "Book",
                        selectedIcon = Icons.Filled.DateRange,
                        unselectedIcon = Icons.Outlined.DateRange,
                        hasNews = true
                    ),
                    BottomNavItem(
                        route = "history_screen",
                        title = "History",
                        selectedIcon = Icons.Filled.ShoppingCart,
                        unselectedIcon = Icons.Outlined.ShoppingCart,
                        hasNews = false,
                        badgeCount = 40
                    ),
                ) , navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        }
    ) {
        BottomNavigation(navController = navController)
    }
}
