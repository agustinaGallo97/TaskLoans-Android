package com.xmartlabs.taskloans.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.xmartlabs.taskloans.ui.dashboard.tabs.BalanceFragment
import com.xmartlabs.taskloans.ui.dashboard.tabs.FriendsFragment
import com.xmartlabs.taskloans.ui.dashboard.tabs.HomeFragment

class ViewPagerAdapter(private val activity: FragmentActivity) : FragmentStateAdapter(activity) {
  override fun getItemCount(): Int = 3

  override fun createFragment(position: Int): Fragment {
    return when (position) {
      0 -> HomeFragment()
      1 -> BalanceFragment()
      2 -> FriendsFragment()
      else -> FriendsFragment()
    }
  }
}
