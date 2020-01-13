package com.xmartlabs.taskloans.di

import com.xmartlabs.bigbang.core.repository.CoreSessionRepository
import com.xmartlabs.bigbang.core.repository.SharedPreferencesSource
import com.xmartlabs.taskloans.repository.SessionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
  @Provides
  @Singleton
  internal fun provideSessionController(sharedPreferencesController: SharedPreferencesSource) =
      SessionRepository(sharedPreferencesController)

  @Provides
  @Singleton
  internal fun provideCoreSessionController(sessionRepository: SessionRepository): CoreSessionRepository =
      sessionRepository
}
