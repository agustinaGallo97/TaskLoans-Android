package com.xmartlabs.taskloans.tests.signin

import com.xmartlabs.taskloans.App
import com.xmartlabs.taskloans.R
import com.xmartlabs.taskloans.common.BaseUnitTest
import com.xmartlabs.taskloans.repository.AuthRepository
import com.xmartlabs.taskloans.service.AuthService
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.RequestsVerifier
import io.appflate.restmock.utils.RequestMatchers
import okhttp3.mockwebserver.MockResponse
import org.hamcrest.core.AllOf.allOf
import org.junit.Assert
import org.junit.Test
import javax.inject.Inject

class SignInUnitTest : BaseUnitTest() {
  companion object {
    private val POST_ACCESS_TOKEN_MATCHER =
        allOf(RequestMatchers.isPOST(), RequestMatchers.pathContains(AuthService.URL_ACCESS_TOKEN))
  }

  @Inject
  internal lateinit var authRepository: AuthRepository

  override fun setUp() {
    super.setUp()
    testComponent.inject(this)
  }

  @Test
  fun signInTest() {
    authRepository.signIn().blockingAwait()
  }

  @Test
  fun testAccessTokenOk() {
    RESTMockServer.whenRequested(POST_ACCESS_TOKEN_MATCHER)
        .thenReturn(MockResponse().setResponseCode(411))

    authRepository.accessToken
        .ignoreElement()
        .onErrorComplete()
        .blockingAwait()

    RequestsVerifier.verifyRequest(POST_ACCESS_TOKEN_MATCHER).invoked()
  }

  @Test
  fun testMockString() {
    Assert.assertEquals(DEFAULT_MOCK_STRING, App.context.getString(R.string.app_name))
  }
}
