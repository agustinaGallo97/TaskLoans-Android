package com.xmartlabs.template.service.response

import com.xmartlabs.template.model.Entry
import com.xmartlabs.template.model.Task

data class EntryResponse(
    var entry: Entry? = null,
    var task: Task? = null
)
