package com.xmartlabs.template.model.relationshipModels

import androidx.room.Embedded
import androidx.room.Relation
import com.xmartlabs.template.model.Balance
import com.xmartlabs.template.model.User

data class UserAndBalance(
    @Embedded val balance: Balance,
    @Relation(
        parentColumn = "balanceId",
        entityColumn = "balanceAssociatedId"
    )
    val user: User
)
