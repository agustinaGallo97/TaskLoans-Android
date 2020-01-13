package com.xmartlabs.taskloans.service.request

import java.util.Date

data class EntryRequest(
    var recipients: List<Int>,
    var date: Date
)
