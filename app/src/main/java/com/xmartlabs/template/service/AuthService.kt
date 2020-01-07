package com.xmartlabs.template.service

import com.xmartlabs.template.service.request.UserRequest

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
  companion object {
    const val SIGN_UP = "signup"
    const val SIGN_IN = "signin"
  }
  @POST(SIGN_UP)
  fun signUpUser(@Body body: UserRequest): Single<com.xmartlabs.template.service.response.AuthResponse>

  @POST(SIGN_IN)
  fun signInUser(@Body body: UserRequest): Single<com.xmartlabs.template.service.response.AuthResponse>
}
