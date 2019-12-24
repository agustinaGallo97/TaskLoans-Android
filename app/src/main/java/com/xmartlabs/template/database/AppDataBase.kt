package com.xmartlabs.template.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.xmartlabs.template.database.converter.DateConverter
import com.xmartlabs.template.database.dao.BalanceDao
import com.xmartlabs.template.database.dao.EntryDao
import com.xmartlabs.template.database.dao.TaskDao
import com.xmartlabs.template.database.dao.UserDao
import com.xmartlabs.template.model.Balance
import com.xmartlabs.template.model.Entry
import com.xmartlabs.template.model.Task
import com.xmartlabs.template.model.User

@Database(
    entities = [
      Balance::class,
      Entry::class,
      Task::class,
      User::class
    ],
    version = 1,
    exportSchema = true)
@TypeConverters(DateConverter::class)
abstract class AppDataBase : RoomDatabase() {
  abstract fun balanceDao(): BalanceDao
  abstract fun entryDao(): EntryDao
  abstract fun taskDao(): TaskDao
  abstract fun userDao(): UserDao
}
