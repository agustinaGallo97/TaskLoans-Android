package com.xmartlabs.taskloans.model.relationshipModels

import androidx.room.Embedded
import androidx.room.Relation
import com.xmartlabs.taskloans.model.Task
import com.xmartlabs.taskloans.model.User

data class UserWithTaskLists(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userAssociatedId"
    )
    val tasks: List<Task>
)
