package com.za.instagramprofileuijetpack.presentation.authscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.za.instagramprofileuijetpack.R
import com.za.instagramprofileuijetpack.presentation.navigation.Screen
import com.za.instagramprofileuijetpack.ui.theme.ButtonBack

@Composable
fun LoginScreen(navController:NavController) {
    LoginView(
        onItemClick = {navController.navigate(Screen.LoginScreen2.route)},
        onButtonClicked = {navController.navigate(Screen.MainScreen.route)}
    )
}

@Composable
fun LoginView(
    onItemClick: () -> Unit,
    onButtonClicked: () -> Unit
) {
    Column (modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.instagram_logo), contentDescription = null)
            Spacer(modifier = Modifier.size(36.dp))
            Image(
                painter = painterResource(id = R.drawable.eagle),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(85.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "eagle",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.size(12.dp))
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(5.dp))
                    .height(44.dp)
                    .fillMaxWidth()
                    .background(ButtonBack)
                    .clickable { onButtonClicked() }
                    ,
                contentAlignment = Alignment.Center

            ){
                Text(
                    text = "Log in",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.size(28.dp))
            Text(text = "Switch Account",
                color = ButtonBack,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.clickable { onItemClick() }
            )

        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    text = "Don’t have an account?",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = " Sign up.",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }
        }

    }
}

//@Preview
//@Composable
//fun LoginScreenPreview() {
//    LoginView()
//}