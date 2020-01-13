package com.xmartlabs.taskloans.service.response

import com.xmartlabs.taskloans.model.Entry
import com.xmartlabs.taskloans.model.Task

data class EntryResponse(
    var entry: Entry? = null,
    var task: Task? = null
)
