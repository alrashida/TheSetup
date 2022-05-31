package com.mysus.myfav.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize



@Parcelize
data class KesukaanItem(
    var id: Int = 0,
    @Json(name = "imgurl")
    var imgurl: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "Desc")
    val Desc: String?,
) : Parcelable
