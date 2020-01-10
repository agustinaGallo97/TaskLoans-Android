package com.xmartlabs.template.di

import com.xmartlabs.template.ui.StartActivity
import com.xmartlabs.template.ui.login.LoginActivity
import com.xmartlabs.template.ui.onboarding.signIn.SignInActivity
import com.xmartlabs.template.ui.onboarding.signUp.SignUpActivity
import com.xmartlabs.template.ui.recyclerfragmentexample.RecyclerExampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
  @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
  abstract fun contributeLoginActivity(): LoginActivity

  @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
  abstract fun contributeSignUpActivity(): SignUpActivity

  @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
  abstract fun contributeSignInActivity(): SignInActivity

  @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
  abstract fun contributeRecyclerExampleActivity(): RecyclerExampleActivity

  @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
  abstract fun contributeStartActivity(): StartActivity
}
