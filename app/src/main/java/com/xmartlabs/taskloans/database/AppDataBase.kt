package com.xmartlabs.taskloans.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xmartlabs.taskloans.database.converter.DateConverter
import com.xmartlabs.taskloans.database.dao.BalanceDao
import com.xmartlabs.taskloans.database.dao.EntryDao
import com.xmartlabs.taskloans.database.dao.TaskDao
import com.xmartlabs.taskloans.database.dao.UserDao
import com.xmartlabs.taskloans.model.Balance
import com.xmartlabs.taskloans.model.Entry
import com.xmartlabs.taskloans.model.Task
import com.xmartlabs.taskloans.model.User

@Database(
    entities = [
      Balance::class,
      Entry::class,
      Task::class,
      User::class
    ],
    version = 2,
    exportSchema = true)
@TypeConverters(DateConverter::class)
abstract class AppDataBase : RoomDatabase() {
  abstract fun balanceDao(): BalanceDao
  abstract fun entryDao(): EntryDao
  abstract fun taskDao(): TaskDao
  abstract fun userDao(): UserDao
}
