package com.example.simplemenuexample.models.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UserTestData(
    @SerializedName("data")
    var data: Array<String>? = null
) : Parcelable {
    constructor(parcel: Parcel): this() {
        parcel.run{
            data = readArrayList()
        }
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserTestData> {
        override fun createFromParcel(parcel: Parcel): UserTestData {
            return UserTestData(parcel)
        }

        override fun newArray(size: Int): Array<UserTestData?> {
            return arrayOfNulls(size)
        }
    }
}