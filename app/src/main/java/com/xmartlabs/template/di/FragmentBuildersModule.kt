package com.xmartlabs.template.di

import com.xmartlabs.template.ui.login.LoginFragment
import com.xmartlabs.template.ui.onboarding.signUp.SignUpFragment
import com.xmartlabs.template.ui.recyclerfragmentexample.RecyclerExampleFragment
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
