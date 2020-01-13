package com.xmartlabs.taskloans.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xmartlabs.taskloans.model.User
import com.xmartlabs.taskloans.model.relationshipModels.UserWithTaskLists

@Dao
interface UserDao {
  @Query("SELECT * FROM user")
  fun getUsers(): LiveData<List<UserWithTaskLists>>

  @Query("SELECT * FROM user WHERE id=(:id)")
  fun getUser(id: Int): LiveData<UserWithTaskLists?>

  @Update
  fun updateUser(user: User)

  @Insert
  fun addUser(user: User)
}
