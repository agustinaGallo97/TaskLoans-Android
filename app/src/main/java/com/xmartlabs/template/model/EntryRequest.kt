package com.xmartlabs.template.model

import java.util.Date

data class EntryRequest(
    var recipients: List<Int>,
    var date: Date
)
