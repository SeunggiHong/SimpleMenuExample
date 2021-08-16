package com.example.simplemenuexample.models.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "users")
@Parcelize
data class UserData(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "first_name") var firstName: String?,
    @ColumnInfo(name = "lastName") var lastName: String?
) : Parcelable
