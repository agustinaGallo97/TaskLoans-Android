package com.xmartlabs.template.service

import com.xmartlabs.template.model.Balance
import com.xmartlabs.template.model.Entry
import com.xmartlabs.template.model.EntryRequest
import com.xmartlabs.template.model.EntryResponse
import com.xmartlabs.template.model.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskService {
  @GET("/tasks/1/users/{user_id}/entries")
  fun getEntries(@Path("user_id") userId: String): Single<List<Entry>>

  @POST("/tasks/1/users/{user_id}/entries")
  fun createEntry(@Path("user_id") userId: String, @Body body: EntryRequest): Single<EntryResponse>

  @GET("/tasks/1/users")
  fun getTaskUsers(): Single<List<User>>

  @GET("tasks/1/balance")
  fun getTaskBalance(): Single<List<Balance>>
}
