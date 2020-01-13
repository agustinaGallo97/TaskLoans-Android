package com.xmartlabs.taskloans.model.relationshipModels

import androidx.room.Embedded
import androidx.room.Relation
import com.xmartlabs.taskloans.model.Entry
import com.xmartlabs.taskloans.model.User

data class EntryWithUsers(
    @Embedded val entry: Entry,
    @Relation(
        parentColumn = "entryId",
        entityColumn = "entryAssociatedId"
    )
    val userList: List<User>,

    @Relation(
        parentColumn = "entryId",
        entityColumn = "entryAssociatedToPerformerId"
    )
    val user: User
)
