package com.xmartlabs.taskloans.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: Int? = null,
    val name: String? = null,
    val email: String? = null,
    val entryAssociatedId: Int? = 0,
    val entryAssociatedToPerformerId: Int? = 0,
    val balanceAssociatedId: Int? = 0
)
