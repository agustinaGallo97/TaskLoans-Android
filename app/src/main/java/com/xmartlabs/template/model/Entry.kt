package com.xmartlabs.template.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Entry(
    @PrimaryKey var entryId: Int? = 0,
    val date: Date,
    var note: String? = null
)
