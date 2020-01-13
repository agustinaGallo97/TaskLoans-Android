package com.xmartlabs.taskloans.di

import com.xmartlabs.taskloans.repository.AuthRepository
import com.xmartlabs.taskloans.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
  @Provides
  @Singleton
  internal fun provideSignUpUseCase(
      authRepository: AuthRepository
  ) = SignUpUseCase(authRepository)
}
