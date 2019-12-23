package com.xmartlabs.template.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import android.os.Handler
import com.xmartlabs.template.repository.common.NetworkState
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {
  private val _login = MutableLiveData<Pair<String, String>>()

  val login: LiveData<NetworkState>
    get() =
      Transformations.switchMap(_login) { _ ->
        val serviceCall = MutableLiveData<NetworkState>()
        serviceCall.value = NetworkState.LOADING
        @Suppress("MagicNumber")
        Handler().postDelayed({
          serviceCall.value = NetworkState.LOADED
        }, 3000)
        serviceCall
      }

  fun login(username: String, password: String) {
    _login.value = Pair(username, password)
  }
}
