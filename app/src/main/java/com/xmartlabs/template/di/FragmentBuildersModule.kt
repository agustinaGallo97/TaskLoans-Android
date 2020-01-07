package com.xmartlabs.template.di

import com.xmartlabs.template.ui.login.LoginFragment
import com.xmartlabs.template.ui.onboarding.signUp.SignUpFragment
import com.xmartlabs.template.ui.onboardingg.OnboardingFragment
import com.xmartlabs.template.ui.onboardingg.page.OnboardingPageFragment
import com.xmartlabs.template.ui.recyclerfragmentexample.RecyclerExampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
  @ContributesAndroidInjector
  abstract fun contributeLoginFragment(): LoginFragment

  @ContributesAndroidInjector
  abstract fun contributeSignUpFragment(): SignUpFragment

  @ContributesAndroidInjector
  abstract fun contributeOnboardingFragment(): OnboardingFragment

  @ContributesAndroidInjector
  abstract fun contributeOnboardingPageFragment(): OnboardingPageFragment

  @ContributesAndroidInjector
  abstract fun contributeRecyclerExampleFragment(): RecyclerExampleFragment
}
