package com.xmartlabs.template.service

import com.xmartlabs.template.service.request.UserRequest
import com.xmartlabs.template.service.response.AuthResponse

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
  companion object {
    private const val URL_SIGN_UP = "signup"
    private const val URL_SIGN_IN = "signin"
  }
  @POST(URL_SIGN_UP)
  fun signUpUser(@Body body: UserRequest): Single<AuthResponse>

  @POST(URL_SIGN_IN)
  fun signInUser(@Body body: UserRequest): Single<AuthResponse>
}
