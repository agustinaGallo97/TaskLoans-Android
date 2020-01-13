package com.xmartlabs.taskloans.common

import com.xmartlabs.taskloans.App
import com.xmartlabs.taskloans.di.DaggerApplicationComponent
import com.xmartlabs.taskloans.di.MockAndroidModule
import com.xmartlabs.taskloans.di.MockClockModule
import com.xmartlabs.taskloans.di.MockRestServiceModule
import com.xmartlabs.taskloans.model.common.BuildInfo
import io.appflate.restmock.RESTMockServerStarter
import io.appflate.restmock.android.AndroidLocalFileParser
import io.appflate.restmock.android.AndroidLogger
import org.junit.Before
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.*

open class BaseUnitTest {
  companion object {
    const val DEFAULT_MOCK_STRING = "This is a mock string"
  }

  internal lateinit var testComponent: TestComponent

  open fun mockStrings() {
    `when`(App.context.getString(ArgumentMatchers.anyInt())).thenReturn(DEFAULT_MOCK_STRING)
  }

  open fun mockTime() {
    TimeZone.setDefault(MockClockModule.DEFAULT_TIME_ZONE)
  }

  @Before
  open fun setUp() {
    App.context = MockAndroidModule.MOCK_CONTEXT

    MockitoAnnotations.initMocks(this)

    RESTMockServerStarter.startSync(AndroidLocalFileParser(App.context), AndroidLogger())
    testComponent = DaggerTestComponent.builder()
        .application(App.context)
        .buildInfo(BuildInfo())
        .restServiceModule(MockRestServiceModule())
        .build()

    mockStrings()
    mockTime()
  }
}
