package com.xmartlabs.taskloans.di

import com.xmartlabs.bigbang.core.repository.SharedPreferencesSource
import com.xmartlabs.taskloans.database.dao.UserDao
import com.xmartlabs.taskloans.repository.AuthRepository
import com.xmartlabs.taskloans.repository.SessionRepository
import com.xmartlabs.taskloans.service.AuthService
import com.xmartlabs.taskloans.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
  @Provides
  @Singleton
  internal fun provideSignUpUseCase(
      authService: AuthService,
      sessionRepository: SessionRepository,
      sharedPreferencesSource: SharedPreferencesSource,
      userDao: UserDao
  ) = SignUpUseCase(AuthRepository(authService, sessionRepository, userDao, sharedPreferencesSource))
}
