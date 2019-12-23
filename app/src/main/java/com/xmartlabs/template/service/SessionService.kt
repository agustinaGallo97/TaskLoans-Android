package com.xmartlabs.template.service

import com.xmartlabs.template.R
import com.xmartlabs.template.model.UserRequest
import com.xmartlabs.template.model.UserResponse

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface SessionService {
  companion object {
    const val BASE_URL = R.string.base_url.toString()
    const val SIGN_UP_PATH = "$BASE_URL/signup"
    const val SIGN_IN_PATH = "$BASE_URL/signin"
  }

  @POST(SIGN_UP_PATH)
  fun signUpUser(@Body body: UserRequest): Single<UserResponse>

  @POST(SIGN_IN_PATH)
  fun signInUser(@Body body: UserRequest): Single<UserResponse>
}
