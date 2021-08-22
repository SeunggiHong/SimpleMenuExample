package com.example.simplemenuexample.models.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestItem(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("user_name")
    val user_name: String? = null,
    @SerializedName("user_email")
    val user_email: String? = null,
    @SerializedName("user_phone")
    val user_phone: String? = null,
    @SerializedName("user_content")
    val user_content: String? = null,
    @SerializedName("user_image")
    val user_image: String? = null
) : Parcelable