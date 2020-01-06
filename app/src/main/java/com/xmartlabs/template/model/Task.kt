package com.xmartlabs.template.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val taskId: Int? = null,
    val userAssociatedId: Int? = null,
    val name: String? = null
)
