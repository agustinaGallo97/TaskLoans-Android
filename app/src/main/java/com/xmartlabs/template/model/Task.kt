package com.xmartlabs.template.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val taskId: Int? = 0,
    val userAssociatedId: Int? = 0,
    val name: String? = null
)
