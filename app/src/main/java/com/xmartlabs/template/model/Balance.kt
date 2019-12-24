package com.xmartlabs.template.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Balance(
    @PrimaryKey val balanceId: Int? = 0,
    val favour: Int? = 0,
    val against: Int? = 0
)
