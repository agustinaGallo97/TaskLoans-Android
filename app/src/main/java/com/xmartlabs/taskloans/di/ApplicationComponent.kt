package com.xmartlabs.taskloans.di

import android.app.Application
import com.xmartlabs.bigbang.core.module.AndroidModule
import com.xmartlabs.bigbang.core.module.GsonModule
import com.xmartlabs.bigbang.core.module.PicassoModule
import com.xmartlabs.bigbang.retrofit.module.RestServiceModule
import com.xmartlabs.bigbang.retrofit.module.ServiceGsonModule
import com.xmartlabs.taskloans.App
import com.xmartlabs.taskloans.model.common.BuildInfo
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [
  ActivityModule::class,
  AndroidInjectionModule::class,
  AndroidModule::class,
  AppModule::class,
  RepositoryModule::class,
  DbModule::class,
  GsonModule::class,
  OkHttpModule::class,
  PicassoModule::class,
  RestServiceModule::class,
  RestServiceModuleApi::class,
  ServiceGsonModule::class,
  ViewModelModule::class
])
@Singleton
interface ApplicationComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    @BindsInstance
    fun buildInfo(buildInfo: BuildInfo): Builder

    fun restServiceGsonModule(serviceGsonModule: ServiceGsonModule): Builder

    fun restServiceModule(restService: RestServiceModule): Builder

    fun okHttpModule(okHttpModule: OkHttpModule): Builder

    fun build(): ApplicationComponent
  }

  fun inject(app: App)
}
