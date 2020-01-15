package com.xmartlabs.taskloans.ui.dashboard

import com.f2prateek.dart.HensonNavigable
import com.xmartlabs.bigbang.ui.SingleFragmentActivity

@HensonNavigable
class DashboardActivity : SingleFragmentActivity() {

  override fun createFragment() = DashboardFragmentBuilder().build()
}
