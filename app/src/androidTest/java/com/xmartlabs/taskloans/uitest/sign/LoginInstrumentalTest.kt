package com.xmartlabs.taskloans.uitest.sign

import com.xmartlabs.bigbang.test.extensions.checkHasText
import com.xmartlabs.bigbang.test.extensions.checkIsDisplayed
import com.xmartlabs.bigbang.test.helpers.EspressoUtils
import com.xmartlabs.taskloans.R
import com.xmartlabs.taskloans.common.SingleActivityInstrumentationTest
import com.xmartlabs.taskloans.ui.login.LoginActivity
import org.junit.Test

class LoginInstrumentalTest : SingleActivityInstrumentationTest<LoginActivity>() {
  override val activityClass: Class<LoginActivity>
    get() = LoginActivity::class.java

  @Test
  fun testSignInButtonIsVisible() {
    launchActivityWithDefaultIntent()
    EspressoUtils.onViewWithId(R.id.loginButton)
        .checkIsDisplayed()
  }

  @Test
  fun testSignInButtonText() {
    launchActivityWithDefaultIntent()
    EspressoUtils.onViewWithId(R.id.loginButton)
        .checkHasText(R.string.login)
  }
}
