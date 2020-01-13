package com.xmartlabs.template.ui.onboarding.signup

import com.f2prateek.dart.HensonNavigable
import com.xmartlabs.bigbang.ui.SingleFragmentActivity

@HensonNavigable
class SignUpActivity : SingleFragmentActivity() {
  override fun createFragment() = SignUpFragmentBuilder().build()
}
