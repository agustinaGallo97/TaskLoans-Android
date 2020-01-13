package com.xmartlabs.taskloans.service

import com.xmartlabs.taskloans.model.Balance
import com.xmartlabs.taskloans.model.Entry
import com.xmartlabs.taskloans.service.request.EntryRequest
import com.xmartlabs.taskloans.service.response.EntryResponse
import com.xmartlabs.taskloans.model.User
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskService {
  companion object {
    const val BASE_TASK_BALANCE_PATH = "tasks/1/balance"
    const val BASE_TASK_USER_PATH = "/tasks/1/users"
    const val ENTRY_PATH = "$BASE_TASK_USER_PATH/{user_id}/entries"
  }

  @GET(ENTRY_PATH)
  fun getEntries(@Path("user_id") userId: String): Single<List<Entry>>

  @POST(ENTRY_PATH)
  fun createEntry(@Path("user_id") userId: String, @Body body: EntryRequest): Single<EntryResponse>

  @GET(BASE_TASK_USER_PATH)
  fun getTaskUsers(): Single<List<User>>

  @GET(BASE_TASK_BALANCE_PATH)
  fun getTaskBalance(): Single<List<Balance>>
}
