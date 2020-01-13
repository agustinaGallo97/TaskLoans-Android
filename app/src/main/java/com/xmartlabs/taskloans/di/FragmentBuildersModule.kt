package com.xmartlabs.taskloans.di

import com.xmartlabs.taskloans.ui.login.LoginFragment
import com.xmartlabs.taskloans.ui.onboarding.signup.SignUpFragment
import com.xmartlabs.taskloans.ui.recyclerfragmentexample.RecyclerExampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
  @ContributesAndroidInjector
  abstract fun contributeLoginFragment(): LoginFragment

  @ContributesAndroidInjector
  abstract fun contributeRecyclerExampleFragment(): RecyclerExampleFragment

  @ContributesAndroidInjector
  abstract fun contributeSignUpFragment(): SignUpFragment
}
