package supermegadeveloper.ayana.lab3

import android.os.Parcel
import android.os.Parcelable

data class ListItem(var title : String, var date : String) : Parcelable {
    constructor(parcel : Parcel) : this(
            parcel.readString(),
            parcel.readString()){

    }

    companion object CREATOR : Parcelable.Creator<ListItem> {
        override fun createFromParcel(parcel: Parcel): ListItem {
            return ListItem(parcel)
        }

        override fun newArray(size: Int): Array<ListItem?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(date)

    }

    override fun describeContents(): Int {
        return 0
    }
}