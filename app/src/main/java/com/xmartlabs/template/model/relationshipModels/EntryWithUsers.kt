package com.xmartlabs.template.model.relationshipModels

import androidx.room.Embedded
import androidx.room.Relation
import com.xmartlabs.template.model.Entry
import com.xmartlabs.template.model.User

data class EntryWithUsers(
    @Embedded val entry: Entry,
    @Relation(
        parentColumn = "entryId",
        entityColumn = "entryAssociatedId"
    )
    val userList: List<User>

)
