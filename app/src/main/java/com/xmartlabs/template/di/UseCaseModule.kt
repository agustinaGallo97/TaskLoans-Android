package com.xmartlabs.template.di

import com.xmartlabs.bigbang.core.repository.SharedPreferencesSource
import com.xmartlabs.template.database.dao.UserDao
import com.xmartlabs.template.repository.AuthRepository
import com.xmartlabs.template.repository.SessionRepository
import com.xmartlabs.template.service.AuthService
import com.xmartlabs.template.usecase.SignUpUseCase
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
  ): SignUpUseCase = SignUpUseCase(AuthRepository(authService, sessionRepository, userDao, sharedPreferencesSource))
}
