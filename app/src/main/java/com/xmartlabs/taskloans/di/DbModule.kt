package com.xmartlabs.taskloans.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xmartlabs.taskloans.database.AppDataBase
import com.xmartlabs.taskloans.database.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
  @Singleton
  @Provides
  fun provideDb(app: Application) = Room
      .databaseBuilder(app, AppDataBase::class.java, "templatedb.db")
      .fallbackToDestructiveMigration()
      .build()

  @Singleton
  @Provides
  fun provideRoomDb(db: AppDataBase): RoomDatabase = db

  @Provides
  @Singleton
  fun provideUserDao(db: AppDataBase): UserDao = db.userDao()
}
