package com.za.instagramprofileuijetpack.presentation.searchscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.za.instagramprofileuijetpack.R
import com.za.instagramprofileuijetpack.ui.theme.TextFieldBack

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.size(16.dp))
        TopBarSearch()
        Spacer(modifier = Modifier.size(8.dp))
        OptionsRow()
        Spacer(modifier = Modifier.size(8.dp))
        PostSection(
            posts = listOf(
                painterResource(id = R.drawable.pic1),
                painterResource(id = R.drawable.pic2),
                painterResource(id = R.drawable.pic3),
                painterResource(id = R.drawable.pic4),
                painterResource(id = R.drawable.pic5),
                painterResource(id = R.drawable.pic6),
                painterResource(id = R.drawable.pic7),
                painterResource(id = R.drawable.pic8),
                painterResource(id = R.drawable.pic9),
            ),
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSearch() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = "",
            onValueChange = {},
            Modifier
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(10.dp)
                )
                .height(49.dp)
                .weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = TextFieldBack,
                textColor = Color.Black,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = { Text(
                text = "Search",
                fontSize = 16.sp,
            ) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_search),
                    contentDescription = null
                )
            }
        )
        Icon(
            painter = painterResource(id = R.drawable.search_camera),
            contentDescription = null,
            modifier = Modifier.size(width = 20.dp, height = 20.dp)
        )

    }
}

@Composable
fun OptionsRow() {
    val listOptions = arrayListOf<optionsList>(
        optionsList(R.drawable.search_video, "IGTV"),
        optionsList(R.drawable.store_search, "Shop"),
        optionsList(null, "Style"),
        optionsList(null, "Sports"),
        optionsList(null, "Auto"),
        optionsList(null, "Music")
    )
    LazyRow(modifier = Modifier.fillMaxWidth(),
        content = {
        items(listOptions){item ->
            Spacer(modifier = Modifier.size(8.dp))
            OptionForRow(item.text,item.icon)
        }
    })

}

@Composable
fun OptionForRow(
      text:String,
      icon:Int? = null
) {
    Card(
        modifier = Modifier
            .height(32.dp)
            .background(Color.Transparent)
            ,
        shape = RoundedCornerShape(6.dp),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            if (icon != null){
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null
                )
            }
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

        }

    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}

data class optionsList(
    val icon: Int?,
    val text: String
)


@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}