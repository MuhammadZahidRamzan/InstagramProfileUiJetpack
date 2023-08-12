package com.za.instagramprofileuijetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                        startDestination = Screen.PostScreen.route
                    ) {
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