package com.xmartlabs.template.usecase

import com.xmartlabs.template.model.User
import com.xmartlabs.template.repository.AuthRepository
import com.xmartlabs.template.service.request.UserRequest
import io.reactivex.Single
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val authRepository: AuthRepository) :
    BaseSingleUseCase<SignUpUseCase.Params, User>() {
  class Params(
      val name: String,
      val mail: String,
      val password: String
  )

  override fun execute(parameters: Params): Single<User> =
      authRepository.signUp(UserRequest(parameters.name, parameters.mail, parameters.password))
}
