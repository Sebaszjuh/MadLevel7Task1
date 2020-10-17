package com.example.madlevel7task1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val firstName: String,
val lastName: String,
val description: String,
val imageUri: String?
) : Parcelable
