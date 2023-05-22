package com.example.mybottomnav.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Plant(
    var photoUrl: Int,
    var nama: String,
    var detail: String
) :Parcelable{
    constructor(parcel: Parcel) : this(
        (parcel.readValue(Int::class.java.classLoader) as? Int)!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(photoUrl)
        parcel.writeString(nama)
        parcel.writeString(detail)
    }

    companion object CREATOR : Parcelable.Creator<Plant> {
        override fun createFromParcel(parcel: Parcel): Plant {
            return Plant(parcel)
        }

        override fun newArray(size: Int): Array<Plant?> {
            return arrayOfNulls(size)
        }
    }
}