package net.noor.planetsapplication

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by nsamir on 6/6/2019.
 */
class Planet() : Parcelable {

    var name: String = ""
    var description: String = ""
    var image: Int = 0

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        description = parcel.readString()
        image = parcel.readInt()
    }

    constructor(name: String, description: String, image: Int) : this() {
        this.name = name
        this.description = description
        this.image = image
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Planet> {
        override fun createFromParcel(parcel: Parcel): Planet {
            return Planet(parcel)
        }

        override fun newArray(size: Int): Array<Planet?> {
            return arrayOfNulls(size)
        }
    }
}
