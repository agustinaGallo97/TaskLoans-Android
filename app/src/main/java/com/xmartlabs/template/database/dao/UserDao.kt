package com.xmartlabs.template.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.xmartlabs.template.model.User
import com.xmartlabs.template.model.relationshipModels.UserWithTaskLists

@Dao
interface UserDao {
  @Transaction
  @Query("SELECT * FROM user")
  fun getUsers(): LiveData<List<UserWithTaskLists>>

  @Transaction
  @Query("SELECT * FROM user WHERE userId=(:id)")
  fun getUser(id: Int): LiveData<UserWithTaskLists?>

  @Update
  fun updateUser(user: User)

  @Insert
  fun addUser(user: User)
}
