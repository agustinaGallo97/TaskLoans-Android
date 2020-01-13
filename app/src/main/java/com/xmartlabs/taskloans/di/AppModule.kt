package com.xmartlabs.taskloans.di

import com.xmartlabs.taskloans.model.common.BuildInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.xmartlabs.bigbang.core.model.BuildInfo as CoreBuildInfo

@Module
class AppModule {
  @Provides
  @Singleton
  fun provideBuildInformation(coreBuildInfo: BuildInfo): CoreBuildInfo = coreBuildInfo
}
