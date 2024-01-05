package com.za.instagramprofileuijetpack.presentation.commentscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
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
import com.za.instagramprofileuijetpack.R
import com.za.instagramprofileuijetpack.ui.theme.CommentTopBack

@Composable
fun CommentScreen(){
    Column {
        TopCommentBar(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier
            .size(22.dp)
            .fillMaxWidth())
        SingleComment(
            Comment(name = "zahid",
            comment = "please suggest caption of my post",
            image = painterResource(id = R.drawable.pic1),
            hashTag = listOf("#firsttag","#secondtag"),
            time = "1h")
            )
        Spacer(modifier = Modifier
            .size(16.dp)
            .fillMaxWidth())
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.LightGray)
        )
        Spacer(modifier = Modifier
            .size(18.dp)
            .fillMaxWidth())
        CommentSection(modifier = Modifier.fillMaxWidth(),
            comments = listOf(
                Comment(
                name = "enzeto",
                comment = "looking nice",
                image = painterResource(id = R.drawable.pic2),
                hashTag = listOf("#firsttag","#secondtag"),
                time = "1h") ,
                Comment(
                    name = "boss",
                    comment = "beautifull",
                    image = painterResource(id = R.drawable.pic3),
                    hashTag = listOf("#firsttag","#secondtag"),
                    time = "1h"),
                Comment(
                    name = "john",
                    comment = "nice pose",
                    image = painterResource(id = R.drawable.pic9),
                    hashTag = listOf("#firsttag","#secondtag"),
                    time = "1h")
            )
        )
    }
}
@Composable
fun TopCommentBar(
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(CommentTopBack)
        ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            Text(text = "Comment",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun CommentSection(comments:List<Comment>,
                   modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier.fillMaxWidth()){
        items(comments.size){
            SingleComment(comment = comments[it])
            Spacer(modifier = Modifier.size(18.dp))
        }
    }


}

@Composable
fun SingleComment(
    comment: Comment,
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(start = 8.dp)) {
            Image(
                painter = comment.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Text(text = comment.name,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 8.dp, top = 3.dp)
            )
            Text(text = comment.comment,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 2.dp, top = 3.dp)
            )
        }
        Row(modifier = Modifier.padding(start = 40.dp)) {
            comment.hashTag.forEach { hashTag ->
                Text(text = hashTag,
                    color = Color(0xFF7171FD),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(end = 5.dp))
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = comment.time,
            color = Color.LightGray,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 40.dp))
    }
}