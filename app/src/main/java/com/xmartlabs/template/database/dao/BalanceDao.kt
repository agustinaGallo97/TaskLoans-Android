package com.xmartlabs.template.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.xmartlabs.template.model.relationshipModels.UserAndBalance

@Dao
interface BalanceDao {
  @Query("SELECT * FROM balance")
  fun getBalances(): LiveData<List<UserAndBalance>>
}
