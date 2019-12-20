package com.xmartlabs.template.repository

import com.xmartlabs.bigbang.core.repository.CoreSessionRepository
import com.xmartlabs.bigbang.core.repository.SharedPreferencesSource
import com.xmartlabs.template.model.Session
import javax.inject.Inject

class SessionRepository @Inject constructor(sharedPreferencesSource: SharedPreferencesSource)
  : CoreSessionRepository(sharedPreferencesSource) {
  override fun getSessionType() = Session::class.java

  var session
    get() = abstractSession as? Session?
    set(value) {
      value?.let { saveSession(it) } ?: deleteSession()
    }

  fun update(block: (Session?) -> Session) {
    session = block(session)
  }
}
