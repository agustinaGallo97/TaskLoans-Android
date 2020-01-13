package com.xmartlabs.taskloans

import com.xmartlabs.taskloans.di.ApplicationComponent
import com.xmartlabs.taskloans.di.MockRestServiceModule
import com.xmartlabs.taskloans.model.common.BuildInfo

class TestApplication : App() {
  override fun createComponent(): ApplicationComponent = DaggerInstrumentalTestComponent.builder()
      .application(this)
      .buildInfo(BuildInfo())
      .restServiceModule(MockRestServiceModule())
      .build()
}
