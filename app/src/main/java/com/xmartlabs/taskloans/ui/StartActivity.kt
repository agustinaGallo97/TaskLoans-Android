package com.xmartlabs.taskloans.ui

import android.content.Intent
import android.os.Bundle
import com.f2prateek.dart.HensonNavigable
import com.xmartlabs.bigbang.ui.BaseAppCompatActivity
import com.xmartlabs.taskloans.repository.SessionRepository
import javax.inject.Inject

@HensonNavigable
class StartActivity : BaseAppCompatActivity() {
  @Inject
  internal lateinit var sessionRepository: SessionRepository

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

//    val session = sessionRepository.session
//    if (session == null) {
//      // TODO: handle on start activity no session
      val intent = Henson.with(context)
          .gotoSignInActivity()
          .build()
          .setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION or Intent.FLAG_ACTIVITY_CLEAR_TASK)
      startActivity(intent)
//    } else {
//      TODO("Handle on start activity with session")
//    }
  }
}
