package com.za.instagramprofileuijetpack.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.za.instagramprofileuijetpack.presentation.authscreens.LoginScreen
import com.za.instagramprofileuijetpack.presentation.authscreens.LoginScreen2
import com.za.instagramprofileuijetpack.presentation.commentscreen.CommentScreen
import com.za.instagramprofileuijetpack.presentation.navigation.Navigation
import com.za.instagramprofileuijetpack.presentation.navigation.NavigationItem
import com.za.instagramprofileuijetpack.presentation.navigation.Screen
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
                            route = Screen.MainScreen.route
                        ) {
                            navController.clearBackStack(route = Screen.LoginScreen2.route)
                            navController.clearBackStack(route = Screen.LoginScreen.route)
                            MainScreen(navController)
                        }
                        composable(
                            route = Screen.CommentScreen.route
                        ) {
                            CommentScreen()
                        }
//                        composable(
//                            route = Screen.PostScreen.route
//                        ) {
//                            PostScreen(navController)
//                        }
//                        composable(
//                            route = Screen.ProfileScreen.route
//                        ) {
//                            ProfileScreen()
//                        }
                    }
                }
            }
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen(navController: NavController) {
        val navHostController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavigationBar(navHostController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(navHostController = navHostController, navController)
                }
            }
        )
    }

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        val items = listOf(
            NavigationItem.Home,
            NavigationItem.Search,
            NavigationItem.New,
            NavigationItem.Like,
            NavigationItem.Profile
        )
        BottomAppBar(
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(painterResource(id = item.icon), contentDescription = null) },
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Preview
    @Composable
    fun SimpleComposablePreview() {
        ProfileScreen()
    }
}