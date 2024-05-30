package com.tahaluf.tassessment.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "universities")
data class University(
    @PrimaryKey(autoGenerate = true) val id: Int,

    @SerializedName("name")
    val name: String,
    @SerializedName("domains")
    val domains: ArrayList<String>,
    @SerializedName("web_pages")
    val webPages: ArrayList<String>,
    @SerializedName("alpha_two_code")
    val alphaTwoCode: String,
    @SerializedName("state-province")
    val stateProvidance: String,
    @SerializedName("country")
    val country: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt() ?: 0,
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.createStringArrayList() ?: arrayListOf(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeStringList(domains)
        parcel.writeStringList(webPages)
        parcel.writeString(alphaTwoCode)
        parcel.writeString(country)
        parcel.writeString(stateProvidance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<University> {
        override fun createFromParcel(parcel: Parcel): University {
            return University(parcel)
        }

        override fun newArray(size: Int): Array<University?> {
            return arrayOfNulls(size)
        }
    }
}