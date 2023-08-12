package com.za.instagramprofileuijetpack

sealed class Screen(val route: String) {
    object PostScreen: Screen("post_screen")
    object ProfileScreen: Screen("profile_screen")
    object CommentScreen: Screen("comment_screen")
}