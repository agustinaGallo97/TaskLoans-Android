package com.xmartlabs.template.ui.onboarding.signUp

import androidx.lifecycle.ViewModel
import com.xmartlabs.template.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpViewModel @Inject constructor() : ViewModel() {
  @Inject
  lateinit var signUpUseCase: SignUpUseCase

  fun signUp(name: String, mail: String, password: String) {
    signUpUseCase.executeNow(SignUpUseCase.Params(name, mail, password))
  }
}
