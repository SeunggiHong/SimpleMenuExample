package com.example.simplemenuexample.models.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestUserData(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("msg")
    val msg: String? = null,
    @SerializedName("data")
    var data: List<TestItem?>? = null
) : Parcelable