package com.example.narutocharlist

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Character(
    var name: String,
    var description: String,
    var photo: String,
    var background: String

) : Parcelable
