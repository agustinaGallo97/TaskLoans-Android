package com.xmartlabs.taskloans.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.xmartlabs.taskloans.model.relationshipModels.UserAndBalance

@Dao
interface BalanceDao {
  @Query("SELECT * FROM balance")
  fun getBalances(): LiveData<List<UserAndBalance>>
}
