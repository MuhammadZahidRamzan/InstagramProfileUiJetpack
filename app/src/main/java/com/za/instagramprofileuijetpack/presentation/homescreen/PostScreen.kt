package com.za.instagramprofileuijetpack.presentation.homescreen

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.za.instagramprofileuijetpack.R
import com.za.instagramprofileuijetpack.presentation.navigation.Screen
import com.za.instagramprofileuijetpack.presentation.profilescreen.RoundImage
import com.za.instagramprofileuijetpack.ui.theme.StoryBack

@Composable
fun PostScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopLogoBar()
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(1.dp)
                .background(Color.LightGray)
        )
        StorySection(
            modifier = Modifier.padding(bottom = 5.dp, top = 12.dp),
            storyHighlight = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.pic1),
                    text = "Your Story"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic2),
                    text = "abc"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic3),
                    text = "ag"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic4),
                    text = "hi"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic5),
                    text = "gh"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic6),
                    text = "lol"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.pic1),
                    text = "light"
                ),
            )
        )
        Post(
            post = listOf(
                Post(
                    name = "eagle",
                    address = "los angles",
                    image = painterResource(id = R.drawable.pic2),
                    profileImage = painterResource(id = R.drawable.pic2)
                ),
                (Post(
                    name = "Tiger", address = "Islamabad",
                    image = painterResource(id = R.drawable.pic4),
                    profileImage = painterResource(id = R.drawable.pic4)
                )),
                (Post(
                    name = "Unknown", address = "Islamabad",
                    image = painterResource(id = R.drawable.pic5),
                    profileImage = painterResource(id = R.drawable.pic5)
                )),
                (Post(
                    name = "Cat", address = "Islamabad",
                    image = painterResource(id = R.drawable.pic6),
                    profileImage = painterResource(id = R.drawable.pic6)
                ))
            ),
            onItemClick = {
              //  navController.navigate(Screen.ProfileScreen.route)
            },
            onCommentlick = {
                navController.navigate(Screen.CommentScreen.route)
            }
        )
    }


}

@Composable
fun TopLogoBar(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.camera_logo),
            contentDescription = null,
            modifier = Modifier.padding(end = 12.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.instagram_logo_small),
            contentDescription = null,
        )
        Row {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.TopEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.video_logo),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.oval),
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.padding(start = 5.dp, top = 2.dp)
                )
            }

            Spacer(modifier = Modifier.size(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(25.dp)
            )
        }

    }


}

@Composable
fun StorySection(
    modifier: Modifier = Modifier,
    storyHighlight: List<ImageWithText>
) {
    LazyRow(modifier = modifier.padding(start = 10.dp)) {
        items(storyHighlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 8.dp)
            ) {
                RoundImage(
                    image = storyHighlight[it].image,
                    modifier = Modifier
                        .size(width = 56.dp, height = 56.dp)
                        .border(
                            width = 2.dp,
                            color = StoryBack,
                            shape = CircleShape
                        )
                        .padding(1.5.dp)
                )
                Text(
                    text = storyHighlight[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 2.dp),
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun Post(
    modifier: Modifier = Modifier,
    post: List<Post>,
    onItemClick: () -> Unit,
    onCommentlick: () -> Unit,
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(post.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp)
                        .background(Color.White)
                        .shadow(1.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 11.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(modifier = Modifier.padding(start = 3.dp)) {
                                Image(
                                    painter = post[it].image!!,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                                    modifier = Modifier
                                        .size(width = 32.dp , height = 32.dp)
                                        .clip(CircleShape)
                                        .clickable {
                                            onItemClick()
                                        },
                                )
                                Column(modifier = Modifier.padding(start = 10.dp)) {
                                    Text(
                                        text = post[it].name!!,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 13.sp,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = post[it].address!!,
                                        fontSize = 11.sp
                                    )
                                }
                            }
                            Icon(
                                painter = painterResource(id = R.drawable.ic_more),
                                contentDescription = null
                            )
                        }
                        Image(
                            painter = post[it].profileImage!!, contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        LikeCommentSection() {
                            onCommentlick()
                        }
                        Text(
                            text = buildAnnotatedString {
                                val boldStyle = SpanStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )
                                append("Liked by ")
                                pushStyle(boldStyle)
                                append("zahid")
                                pop()
                                append(", ")
                                pushStyle(boldStyle)
                                append("awais")
                                pop()
                                append(" and")
                                pushStyle(boldStyle)
                                append(" 444 others")
                                pop()
                            },
                            Modifier.padding(start = 8.dp, end = 8.dp, top = 5.dp, bottom = 8.dp),
                            fontSize = 13.sp

                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LikeCommentSection(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp , vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_filheart),
                tint = Color.Red,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.size(14.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_commentt),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.clickable {
                    onItemClick()
                }
            )
            Spacer(modifier = Modifier.size(14.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null,
                tint = Color.Black,
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_save),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopLogoBar()
}