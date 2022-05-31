package com.example.bottomsheet.Room

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserDetail(

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var userImg:String?=null,
    var username:String?=null,
    var phoneNumber:String?=null
)
