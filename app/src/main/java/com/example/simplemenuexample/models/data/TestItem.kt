package com.example.simplemenuexample.models.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestItem(
    @SerializedName("id")
    private var id: String? = null,
    @SerializedName("user_name")
    private val user_name: String? = null,
    @SerializedName("user_email")
    private val user_email: String? = null,
    @SerializedName("user_phone")
    private val user_phone: String? = null,
    @SerializedName("user_content")
    private val user_content: String? = null,
    @SerializedName("user_image")
    private val user_image: String? = null
) : Parcelable