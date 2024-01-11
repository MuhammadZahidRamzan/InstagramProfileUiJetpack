package com.za.instagramprofileuijetpack.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.za.instagramprofileuijetpack.R
import com.za.instagramprofileuijetpack.presentation.homescreen.PostScreen
import com.za.instagramprofileuijetpack.presentation.likescreen.LikeScreen
import com.za.instagramprofileuijetpack.presentation.profilescreen.ProfileScreen
import com.za.instagramprofileuijetpack.presentation.searchscreen.SearchScreen

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home_bottom, "Home")
    object Search : NavigationItem("search", R.drawable.ic_search_bottom, "Search")
    object New : NavigationItem("new", R.drawable.ic_new_bottom, "New")
    object Like : NavigationItem("like", R.drawable.ic_like_bottom, "Like")
    object Profile : NavigationItem("profile", R.drawable.ic_profile_bottom, "Profile")
}

@Composable
fun Navigation(navHostController: NavHostController , navController: NavController) {
    NavHost(navHostController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            PostScreen(navController)
        }
        composable(NavigationItem.Search.route) {
            SearchScreen()
        }
        composable(NavigationItem.New.route) {
            NewScreen()
        }
        composable(NavigationItem.Like.route) {
            LikeScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }
}