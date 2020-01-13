package com.xmartlabs.taskloans.model.relationshipModels

import androidx.room.Embedded
import androidx.room.Relation
import com.xmartlabs.taskloans.model.Balance
import com.xmartlabs.taskloans.model.User

data class UserAndBalance(
    @Embedded val balance: Balance,
    @Relation(
        parentColumn = "balanceId",
        entityColumn = "balanceAssociatedId"
    )
    val user: User
)
