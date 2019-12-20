package com.xmartlabs.template.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//TODO: check service auth response to match app's AuthResponse fields
@Parcelize
data class AuthResponse(
    val accessToken: String,
    val scope: String,
    val tokenType: String
) : Parcelable
