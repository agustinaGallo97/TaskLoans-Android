package com.xmartlabs.template.ui.onboarding.signUp

import com.f2prateek.dart.HensonNavigable
import com.xmartlabs.bigbang.ui.SingleFragmentActivity

@HensonNavigable
class SignUpActivity : SingleFragmentActivity() {
  override fun createFragment() = SignUpFragmentBuilder().build()
}
