package com.za.instagramprofileuijetpack.presentation.commentscreen

import androidx.compose.ui.graphics.painter.Painter

data class Comment(
    val name:String,
    val comment:String,
    val image: Painter,
    val hashTag:List<String>,
    val time:String,
    )