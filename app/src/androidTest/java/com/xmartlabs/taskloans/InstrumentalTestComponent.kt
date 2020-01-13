package com.xmartlabs.taskloans

import android.app.Application
import com.xmartlabs.bigbang.core.module.AndroidModule
import com.xmartlabs.bigbang.core.module.GsonModule
import com.xmartlabs.bigbang.core.module.PicassoModule
import com.xmartlabs.bigbang.retrofit.module.RestServiceModule
import com.xmartlabs.bigbang.retrofit.module.ServiceGsonModule
import com.xmartlabs.taskloans.common.BaseInstrumentationTest
import com.xmartlabs.taskloans.di.ActivityModule
import com.xmartlabs.taskloans.di.AppModule
import com.xmartlabs.taskloans.di.ApplicationComponent
import com.xmartlabs.taskloans.di.MockClockModule
import com.xmartlabs.taskloans.di.MockControllerModule
import com.xmartlabs.taskloans.di.OkHttpModule
import com.xmartlabs.taskloans.di.RestServiceModuleApi
import com.xmartlabs.taskloans.di.ViewModelModule
import com.xmartlabs.taskloans.model.common.BuildInfo
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  ActivityModule::class,
  AndroidInjectionModule::class,
  AndroidModule::class,
  AppModule::class,
  GsonModule::class,
  MockClockModule::class,
  MockControllerModule::class,
  OkHttpModule::class,
  PicassoModule::class,
  RestServiceModule::class,
  RestServiceModuleApi::class,
  ServiceGsonModule::class,
  ViewModelModule::class
])
interface InstrumentalTestComponent : ApplicationComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    @BindsInstance
    fun buildInfo(buildInfo: BuildInfo): Builder

    fun restServiceModule(restService: RestServiceModule): Builder

    fun build(): InstrumentalTestComponent
  }

  fun inject(testRunner: TestRunner)

  fun inject(baseInstrumentationTest: BaseInstrumentationTest)
}
