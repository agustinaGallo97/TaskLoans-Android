package com.xmartlabs.taskloans.ui.dashboard

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.taskloans.R
import kotlinx.android.synthetic.main.fragment_viewpager_tablayout.*

@FragmentWithArgs
class DashboardFragment : BaseFragment() {
  override val layoutResId = R.layout.fragment_viewpager_tablayout

  private val adapter by lazy { ViewPagerAdapter(requireActivity()) }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    pager.adapter = adapter
    val tabLayoutMediator = TabLayoutMediator(tabLayout, pager,
        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
          when (DashboardTabs.values()[position]) {
            DashboardTabs.HOME -> {
              tab.setIcon(DashboardTabs.HOME.iconResId)
            }
            DashboardTabs.BALANCE -> {
              tab.setIcon(DashboardTabs.BALANCE.iconResId)
            }
            DashboardTabs.FRIENDS -> {
              tab.setIcon(DashboardTabs.FRIENDS.iconResId)
            }
          }
        })
    tabLayoutMediator.attach()
  }
}
