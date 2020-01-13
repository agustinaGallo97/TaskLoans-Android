package com.xmartlabs.taskloans.di

import com.xmartlabs.taskloans.service.AuthService
import com.xmartlabs.taskloans.service.TaskService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RestServiceModuleApi {
  @Provides
  @Singleton
  internal fun provideAuthService(retrofit: Retrofit) = retrofit.create(AuthService::class.java)

  @Provides
  @Singleton
  internal fun provideTaskService(retrofit: Retrofit) = retrofit.create(TaskService::class.java)
}
