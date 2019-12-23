package com.xmartlabs.template.model

import java.util.Date

data class Entry(
    var id: Int? = 0,
    val date: Date,
    var note: String? = "",
    var performer: User? = null,
    var recipients: List<User>
)
