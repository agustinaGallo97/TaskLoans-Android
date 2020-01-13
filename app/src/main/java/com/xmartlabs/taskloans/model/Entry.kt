package com.xmartlabs.taskloans.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Entry(
    @PrimaryKey var entryId: Int? = null,
    val date: Date,
    var note: String? = null
)
