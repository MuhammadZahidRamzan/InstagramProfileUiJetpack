package com.za.instagramprofileuijetpack.presentation.authscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.za.instagramprofileuijetpack.R
import com.za.instagramprofileuijetpack.presentation.Screen
import com.za.instagramprofileuijetpack.ui.theme.ButtonBack
import com.za.instagramprofileuijetpack.ui.theme.CommentTopBack
import com.za.instagramprofileuijetpack.ui.theme.TextFieldBack

@Composable
fun LoginScreen2(navController: NavController) {
    LoginView2(
        onItemClick = {navController.popBackStack()},
        onButtonClicked = {navController.navigate(Screen.PostScreen.route)}
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView2(
    onItemClick: () -> Unit,
    onButtonClicked: () ->Unit
) {
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {
        Row {
            IconButton(onClick = { onItemClick() },
                Modifier.padding(8.dp)) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    Modifier.size(32.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.instagram_logo), contentDescription = null)
            Spacer(modifier = Modifier.size(36.dp))

            TextField(
                value = "",
                onValueChange = {},
                Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = TextFieldBack,
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = { Text(text = "Enter Name", fontSize = 14.sp)}
            )
            Spacer(modifier = Modifier.size(8.dp))
            TextField(
                value = "",
                onValueChange = {},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = TextFieldBack,
                    textColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp)),
                placeholder = { Text(text = "Password", fontSize = 14.sp)}
            )
            Spacer(modifier = Modifier.size(18.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                textAlign = TextAlign.End,
                text = "Forgot Password?",
                color = ButtonBack,

                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.size(26.dp))
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null
                )
                Text(text = "  Log in with Facebook",
                    color = ButtonBack,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.size(22.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier
                    .background(Color.LightGray)
                    .size(1.dp)
                    .weight(0.4f))
                Text(
                    modifier = Modifier.padding(14.dp),
                    text = "OR",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier
                    .weight(0.4f)
                    .background(Color.LightGray)
                    .size(1.dp))
            }
            Spacer(modifier = Modifier.size(22.dp))
            Row {
                Text(
                    text = "Don’t have an account?",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = " Sign up.",
                    fontSize = 12.sp,
                    color = ButtonBack,
                    fontWeight = FontWeight.SemiBold
                )

            }

        }
        Box (
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

        }

    }
}

//@Preview
//@Composable
//fun LoginScreen2Preview() {
//    LoginView2()
//}