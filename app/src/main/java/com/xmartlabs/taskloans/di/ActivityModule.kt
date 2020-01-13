package com.xmartlabs.taskloans.di

import com.xmartlabs.taskloans.ui.StartActivity
import com.xmartlabs.taskloans.ui.login.LoginActivity
import com.xmartlabs.taskloans.ui.onboarding.signup.SignUpActivity
import com.xmartlabs.taskloans.ui.recyclerfragmentexample.RecyclerExampleActivity
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
  abstract fun contributeRecyclerExampleActivity(): RecyclerExampleActivity

  @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
  abstract fun contributeStartActivity(): StartActivity
}
