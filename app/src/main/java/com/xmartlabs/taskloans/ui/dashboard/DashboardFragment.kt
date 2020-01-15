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
  companion object {
    private const val PAGE_1 = 1
    private const val PAGE_2 = 2
    private const val PAGE_3 = 3
  }

  override val layoutResId = R.layout.fragment_viewpager_tablayout

  private val adapter by lazy { ViewPagerAdapter(requireActivity()) }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    pager.adapter = adapter
    val tabLayoutMediator = TabLayoutMediator(tabLayout, pager,
        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
          when (position + 1) {
            PAGE_1 -> {
              tab.setIcon(R.drawable.account_balance_24_px)
            }
            PAGE_2 -> {
              tab.setIcon(R.drawable.calendar)
            }
            PAGE_3 -> {
              tab.setIcon(R.drawable.friends)
            }
          }
        })
    tabLayoutMediator.attach()
  }
}
