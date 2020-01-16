package com.xmartlabs.taskloans.helper

import android.content.Intent
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.taskloans.App
import com.xmartlabs.taskloans.ui.Henson

object Router {
  fun goToSignUpActivity(fragment: BaseFragment) {
    val intent = Henson.with(App.context)
        .gotoSignUpActivity()
        .build()
        .setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    fragment.startActivity(intent)
  }

  fun goToDashboardActivity(fragment: BaseFragment) {
    val intent = Henson.with(App.context)
        .gotoDashboardActivity()
        .build()
        .setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    fragment.startActivity(intent)
  }
}
