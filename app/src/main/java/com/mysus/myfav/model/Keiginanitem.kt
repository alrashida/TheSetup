package com.mysus.myfav.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Keiginanitem(
    var id: Int = 0,

    @Json(name = "imgurl")
    var imgurl: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "Desc")
    val Desc: String?
) : Parcelable


