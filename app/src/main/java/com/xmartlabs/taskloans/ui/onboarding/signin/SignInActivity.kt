package com.xmartlabs.taskloans.ui.onboarding.signin

import com.f2prateek.dart.HensonNavigable
import com.xmartlabs.bigbang.ui.SingleFragmentActivity

@HensonNavigable
class SignInActivity : SingleFragmentActivity() {
  override fun createFragment() = SignInFragmentBuilder().build()
}
