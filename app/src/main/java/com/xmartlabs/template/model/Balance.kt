package com.xmartlabs.template.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Balance(
    @PrimaryKey val balanceId: Int? = null,
    val favour: Int? = null,
    val against: Int? = null
)
