package com.mysus.myfav.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Entity(tableName = "item")
@Parcelize
data class Keiginanitem(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @Json(name = "imgurl")
    var imgurl: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "Desc")
    val Desc: String?,
    var type :String?
) : Parcelable


