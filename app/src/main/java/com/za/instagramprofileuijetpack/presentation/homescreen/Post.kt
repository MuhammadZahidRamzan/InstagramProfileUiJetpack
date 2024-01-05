package com.za.instagramprofileuijetpack.presentation.homescreen

import androidx.compose.ui.graphics.painter.Painter

data class Post(
    val name:String? = null,
    val address:String? = null,
    val image: Painter? = null,
    val profileImage:Painter? = null,
    val likedBy:List<String>? = null,
    )