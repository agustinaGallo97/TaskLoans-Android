package com.xmartlabs.template.common

import android.app.Activity
import android.app.Instrumentation
import androidx.annotation.CallSuper
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.xmartlabs.bigbang.test.extensions.getFirstActivityInstance
import io.appflate.restmock.RESTMockServer
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseInstrumentationTest {
  lateinit var instrumentation: Instrumentation

  @Before
  @CallSuper
  fun setUp() {
    instrumentation = InstrumentationRegistry.getInstrumentation()
    RESTMockServer.reset()
  }

  val activityInstance: Activity?
    get() = instrumentation.getFirstActivityInstance()
}
