package com.xmartlabs.taskloans.di

import com.xmartlabs.taskloans.ui.dashboard.DashboardFragment
import com.xmartlabs.taskloans.ui.dashboard.tabs.BalanceFragment
import com.xmartlabs.taskloans.ui.dashboard.tabs.UserListFragment
import com.xmartlabs.taskloans.ui.dashboard.tabs.HomeFragment
import com.xmartlabs.taskloans.ui.onboarding.signin.SignInFragment
import com.xmartlabs.taskloans.ui.onboarding.signup.SignUpFragment
import com.xmartlabs.taskloans.ui.recyclerfragmentexample.RecyclerExampleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
  @ContributesAndroidInjector
  abstract fun contributeRecyclerExampleFragment(): RecyclerExampleFragment

  @ContributesAndroidInjector
  abstract fun contributeSignUpFragment(): SignUpFragment

  @ContributesAndroidInjector
  abstract fun contributeSignInFragment(): SignInFragment

  @ContributesAndroidInjector
  abstract fun contributeHomeFragment(): HomeFragment

  @ContributesAndroidInjector
  abstract fun contributeBalanceFragment(): BalanceFragment

  @ContributesAndroidInjector
  abstract fun contributeFriendsFragment(): UserListFragment

  @ContributesAndroidInjector
  abstract fun contributeDashboardFragment(): DashboardFragment
}
