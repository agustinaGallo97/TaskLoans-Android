package com.xmartlabs.taskloans.di

import android.content.Context
import com.xmartlabs.taskloans.App
import com.xmartlabs.taskloans.R
import okhttp3.HttpUrl
import com.xmartlabs.bigbang.retrofit.module.RestServiceModule as CoreRestServiceModule

class RestServiceModule : CoreRestServiceModule() {
  companion object {
    private val BASE_URL = App.context.resources.getString(R.string.base_url)
  }

  @Suppress("UnsafeCallOnNullableType")
  override fun provideBaseUrl(context: Context): HttpUrl = HttpUrl.parse(BASE_URL)!!
}
