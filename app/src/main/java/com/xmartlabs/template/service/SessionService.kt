package com.xmartlabs.template.service

import com.xmartlabs.template.model.UserRequest
import com.xmartlabs.template.model.UserResponse

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface SessionService {

  @POST("signup")
  fun signUpUser(@Body body: UserRequest): Single<UserResponse>

  @POST("signin")
  fun signInUser(@Body body: UserRequest): Single<UserResponse>
}
