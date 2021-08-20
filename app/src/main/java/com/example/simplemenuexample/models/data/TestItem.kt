package com.example.simplemenuexample.models.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TestDataItem(
    @SerializedName("id")
    private var id: String? = null,
    @SerializedName("user_name")
    private var user_name: String? = null,
    @SerializedName("user_email")
    private val user_email: String? = null,
    @SerializedName("user_phone")
    private val user_phone: String? = null,
    @SerializedName("user_content")
    private val user_content: String? = null,
    @SerializedName("user_image")
private val user_image: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel.writeString(id)
    }

    companion object CREATOR : Parcelable.Creator<TestDataItem> {
        override fun createFromParcel(parcel: Parcel): TestDataItem {
            return TestDataItem(parcel)
        }

        override fun newArray(size: Int): Array<TestDataItem?> {
            return arrayOfNulls(size)
        }
    }

}