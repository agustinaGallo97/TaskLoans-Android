package com.xmartlabs.taskloans.ui.dashboard

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xmartlabs.taskloans.R
import com.xmartlabs.taskloans.ui.dashboard.tabs.BalanceFragment
import com.xmartlabs.taskloans.ui.dashboard.tabs.UserListFragment
import com.xmartlabs.taskloans.ui.dashboard.tabs.HomeFragment

class ViewPagerAdapter(private val activity: FragmentActivity) : FragmentStateAdapter(activity) {
  override fun getItemCount(): Int = DashboardTabs.values().size

  override fun createFragment(position: Int): Fragment {
    return when (DashboardTabs.values()[position]) {
      DashboardTabs.HOME -> HomeFragment()
      DashboardTabs.BALANCE -> BalanceFragment()
      DashboardTabs.FRIENDS -> UserListFragment()
    }
  }
}

enum class DashboardTabs(@DrawableRes val iconResId: Int) {
  HOME(R.drawable.account_balance_24_px),
  BALANCE(R.drawable.calendar),
  FRIENDS(R.drawable.friends),
}
