package com.xmartlabs.taskloans.repository

import com.xmartlabs.bigbang.core.extensions.applyIoSchedulers
import com.xmartlabs.bigbang.core.repository.SharedPreferencesSource
import com.xmartlabs.taskloans.database.dao.UserDao
import com.xmartlabs.taskloans.model.Session
import com.xmartlabs.taskloans.service.AuthService
import com.xmartlabs.taskloans.service.request.UserRequest
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

  fun signIn(signInUserRequest: UserRequest) =
      authService.signInUser(signInUserRequest)
          .applyIoSchedulers()
          .doOnSuccess {
            sessionRepository.session = Session(it.token)
          }
          .map { it.user }
}
