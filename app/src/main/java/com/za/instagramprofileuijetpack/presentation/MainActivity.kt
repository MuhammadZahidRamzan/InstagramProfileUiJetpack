package com.za.instagramprofileuijetpack.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.za.instagramprofileuijetpack.presentation.Screen
import com.za.instagramprofileuijetpack.presentation.authscreens.LoginScreen
import com.za.instagramprofileuijetpack.presentation.authscreens.LoginScreen2
import com.za.instagramprofileuijetpack.presentation.commentscreen.CommentScreen
import com.za.instagramprofileuijetpack.presentation.homescreen.PostScreen
import com.za.instagramprofileuijetpack.presentation.profilescreen.ProfileScreen
import com.za.instagramprofileuijetpack.ui.theme.InstagramProfileUiJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramProfileUiJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.LoginScreen.route
                    ) {
                        composable(
                            route = Screen.LoginScreen.route
                        ) {
                            LoginScreen(navController)
                        }
                        composable(
                            route = Screen.LoginScreen2.route
                        ) {
                            LoginScreen2(navController)
                        }
                        composable(
                            route = Screen.CommentScreen.route
                        ) {
                            CommentScreen()
                        }
                        composable(
                            route = Screen.PostScreen.route
                        ) {
                            PostScreen(navController)
                        }
                        composable(
                            route = Screen.ProfileScreen.route
                        ) {
                            ProfileScreen()
                        }
                    }
                }
            }
        }

    }
    @Preview
    @Composable
    fun SimpleComposablePreview() {
        ProfileScreen()
    }
}