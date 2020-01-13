package com.xmartlabs.template.ui.onboarding.signup

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.xmartlabs.template.model.User
import com.xmartlabs.template.usecase.SignUpUseCase
import javax.inject.Inject

class SignUpViewModel @Inject constructor() : ViewModel() {
  private val signUpMutableLiveData = MutableLiveData<SignUpUseCase.Params>()
  @Inject
  lateinit var signUpUseCase: SignUpUseCase

  val signUp: LiveData<Result<User?>> = Transformations.switchMap(signUpMutableLiveData) { params ->
    signUpUseCase.invoke(params)
  }

  @MainThread
  fun signUp(name: String, mail: String, password: String) {
    signUpMutableLiveData.value = SignUpUseCase.Params(name, mail, password)
  }
}
