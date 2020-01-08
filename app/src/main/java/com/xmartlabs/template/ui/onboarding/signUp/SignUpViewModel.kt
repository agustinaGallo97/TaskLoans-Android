package com.xmartlabs.template.ui.onboarding.signUp

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.xmartlabs.template.model.User
import com.xmartlabs.template.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpViewModel @Inject constructor() : ViewModel() {
  private val _signUp = MutableLiveData<SignUpUseCase.Params>()

  @Inject
  lateinit var signUpUseCase: SignUpUseCase

  @MainThread
  fun signUp(name: String, mail: String, password: String) {
    _signUp.value = SignUpUseCase.Params(name, mail, password)
  }

  val signUp: LiveData<Result<User?>>
    get() =
      Transformations.switchMap(_signUp) { params ->
        signUpUseCase.invoke(params)
      }
}
