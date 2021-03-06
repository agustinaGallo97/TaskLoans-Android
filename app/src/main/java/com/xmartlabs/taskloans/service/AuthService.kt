package com.xmartlabs.taskloans.service

import com.xmartlabs.taskloans.service.request.UserRequest
import com.xmartlabs.taskloans.service.response.AuthResponse

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
