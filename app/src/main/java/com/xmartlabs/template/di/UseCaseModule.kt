package com.xmartlabs.template.di

import com.xmartlabs.template.repository.AuthRepository
import com.xmartlabs.template.usecase.SignUpUseCase
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
