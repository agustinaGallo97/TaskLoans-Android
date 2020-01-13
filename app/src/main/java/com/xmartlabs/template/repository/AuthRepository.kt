package com.xmartlabs.template.repository

import com.xmartlabs.bigbang.core.extensions.applyIoSchedulers
import com.xmartlabs.bigbang.core.repository.SharedPreferencesSource
import com.xmartlabs.template.database.dao.UserDao
import com.xmartlabs.template.model.Session
import com.xmartlabs.template.service.AuthService
import com.xmartlabs.template.service.request.UserRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authService: AuthService,
    private val sessionRepository: SessionRepository,
    private val userDao: UserDao,
    sharedPreferencesSource: SharedPreferencesSource
) {
  fun signUp(signUpUserRequest: UserRequest) =
      authService.signUpUser(signUpUserRequest)
          .applyIoSchedulers()
          .doOnSuccess {
            sessionRepository.session = Session(it.token)
            userDao.addUser(it.user)
          }
          .map { it.user }
}
