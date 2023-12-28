package com.dena.auto.taxi.backseat.goatbooking.ui.theme.bottom_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route:String,
    val title:String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)