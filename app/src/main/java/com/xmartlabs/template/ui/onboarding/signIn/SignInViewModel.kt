package com.xmartlabs.template.ui.onboarding.signIn

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.xmartlabs.template.model.User
import com.xmartlabs.template.usecase.SignInUseCase

import javax.inject.Inject

class SignInViewModel @Inject constructor() : ViewModel() {
  private val signInMutableLiveData = MutableLiveData<SignInUseCase.Params>()
  @Inject
  lateinit var signInUseCase: SignInUseCase

  val signIn: LiveData<Result<User?>> = Transformations.switchMap(signInMutableLiveData) { params ->
    signInUseCase.invoke(params)
  }

  @MainThread
  fun signIn(mail: String, password: String) {
    signInMutableLiveData.value = SignInUseCase.Params(mail, password)
  }
}
