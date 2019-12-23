package com.xmartlabs.template.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.xmartlabs.template.ui.onboarding.page.OnboardingPage
import com.xmartlabs.template.ui.onboarding.page.OnboardingPageFragmentBuilder

class OnboardingPageAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
  private val pages = OnboardingPage.values().map { OnboardingPageFragmentBuilder(it).build() }

  override fun getItem(position: Int): Fragment = pages[position]

  override fun getCount() = pages.size
}
