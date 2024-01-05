package com.za.instagramprofileuijetpack.presentation

sealed class Screen(val route: String) {
    object PostScreen: Screen("post_screen")
    object ProfileScreen: Screen("profile_screen")
    object CommentScreen: Screen("comment_screen")
    object LoginScreen: Screen("login_screen")
    object LoginScreen2: Screen("login_screen2")
}