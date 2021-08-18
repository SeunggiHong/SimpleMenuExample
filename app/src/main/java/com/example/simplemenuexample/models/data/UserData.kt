package com.example.simplemenuexample.models.data

import android.net.Uri
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "users")
@Parcelize
data class UserData(
    @PrimaryKey val id: Int?,
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "userEmail") var userEmail: String,
    @ColumnInfo(name = "userPhone") var userPhone: String,
    @ColumnInfo(name = "userContent") var userContent: String,
    @ColumnInfo(name = "userImage") var userImage: String?
) : Parcelable
