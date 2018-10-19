package supermegadeveloper.ayana.mid2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity(tableName = "letter")

data class Letter(@PrimaryKey var id : Int, var title: String, var date: String, var message: String): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(date)
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Letter> {
        override fun createFromParcel(parcel: Parcel): Letter {
            return Letter(parcel)
        }

        override fun newArray(size: Int): Array<Letter?> {
            return arrayOfNulls(size)
        }
    }
}
