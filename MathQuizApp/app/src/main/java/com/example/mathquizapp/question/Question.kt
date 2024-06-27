package com.example.mathquizapp.question

import android.os.Parcel
import android.os.Parcelable

data class Question (
    val problem: String,
    val answer: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    var selectedOption: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(problem)
        parcel.writeString(answer)
        parcel.writeString(option1)
        parcel.writeString(option2)
        parcel.writeString(option3)
        parcel.writeString(option4)
        parcel.writeString(selectedOption)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }
}
