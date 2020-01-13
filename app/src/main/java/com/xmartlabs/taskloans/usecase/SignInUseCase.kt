package com.xmartlabs.taskloans.usecase

import com.xmartlabs.taskloans.model.User
import com.xmartlabs.taskloans.repository.AuthRepository
import com.xmartlabs.taskloans.service.request.UserRequest
import io.reactivex.Single
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val authRepository: AuthRepository) :
    BaseSingleUseCase<SignInUseCase.Params, User?>() {
  class Params(
      val mail: String,
      val password: String
  )

  override fun execute(parameters: Params): Single<User?> =
    authRepository.signIn(UserRequest("", parameters.mail, parameters.password))
}
