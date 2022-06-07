package com.mysus.myfav.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Branditem(
    @Json(name = "namaBrand")
    var namaBrand : String?,
    @Json(name = "data")
    var data : List<KesukaanItem>
) : Parcelable
