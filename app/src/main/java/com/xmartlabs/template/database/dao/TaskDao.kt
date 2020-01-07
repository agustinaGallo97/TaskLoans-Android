package com.xmartlabs.template.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xmartlabs.template.model.Task

@Dao
interface TaskDao {
  @Query("SELECT * FROM task")
  fun getTasks(): LiveData<List<Task>>

  @Query("SELECT * FROM task WHERE taskId=(:id)")
  fun getTask(id: Int): LiveData<Task?>

  @Update
  fun updateTask(task: Task)

  @Insert
  fun addTask(task: Task)
}
