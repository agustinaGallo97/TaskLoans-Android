package com.xmartlabs.template.model.relationshipModels

import androidx.room.Embedded
import androidx.room.Relation
import com.xmartlabs.template.model.Task
import com.xmartlabs.template.model.User

data class UserWithTaskLists(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userAssociatedId"
    )
    val tasks: List<Task>
)
