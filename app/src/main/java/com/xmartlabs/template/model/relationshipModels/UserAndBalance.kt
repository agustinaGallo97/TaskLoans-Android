package com.xmartlabs.template.model.relationshipModels

import androidx.room.Embedded
import androidx.room.Relation
import com.xmartlabs.template.model.Balance
import com.xmartlabs.template.model.User

data class UserAndBalance(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    )
    val balance: Balance
)