package com.xmartlabs.template.service

import com.xmartlabs.template.R
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
  companion object {
    const val BALANCE_TASK_PATH = R.string.balance_task_url.toString()
    const val BASE_TASK_PATH = R.string.base_task_url.toString()
  }

  @GET(BASE_TASK_PATH)
  fun getEntries(@Path("user_id/entries") user_id: String): Single<List<Entry>>

  @POST()
  fun createEntry(@Path("user_id/entries") user_id: String, @Body body: EntryRequest): Single<EntryResponse>

  @GET(BASE_TASK_PATH)
  fun getTaskUsers(): Single<List<User>>

  @GET(BALANCE_TASK_PATH)
  fun getTaskBalance(): Single<List<Balance>>
}
