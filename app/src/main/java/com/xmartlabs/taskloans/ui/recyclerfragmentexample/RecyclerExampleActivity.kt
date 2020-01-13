package com.xmartlabs.taskloans.ui.recyclerfragmentexample

import com.f2prateek.dart.HensonNavigable
import com.xmartlabs.bigbang.ui.SingleFragmentActivity

@HensonNavigable
class RecyclerExampleActivity : SingleFragmentActivity() {
  override fun createFragment() = RecyclerExampleFragmentBuilder().build()
}
