package com.xmartlabs.taskloans.usecase

import com.xmartlabs.taskloans.model.User
import com.xmartlabs.taskloans.repository.AuthRepository
import com.xmartlabs.taskloans.service.request.UserRequest
import io.reactivex.Single
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val authRepository: AuthRepository) :
    BaseSingleUseCase<SignUpUseCase.Params, User?>() {
  class Params(
      val name: String,
      val mail: String,
      val password: String
  )

  override fun execute(parameters: Params): Single<User?> =
      authRepository.signUp(UserRequest(parameters.name, parameters.mail, parameters.password))
}
