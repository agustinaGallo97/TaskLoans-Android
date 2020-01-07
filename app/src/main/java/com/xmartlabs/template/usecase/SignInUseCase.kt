// package com.xmartlabs.template.usecase
//
// import com.xmartlabs.template.model.User
// import com.xmartlabs.template.repository.AuthRepository
// import io.reactivex.Single
//
// class SignInUseCase(private val authRepository: AuthRepository) : BaseSingleUseCase<SignInUseCase.Params, User>(){
//  class Params(val name: String)
//
//  override fun execute(parameters: Params): Single<User> {
//    authRepository.signUp()
//  }
// }
