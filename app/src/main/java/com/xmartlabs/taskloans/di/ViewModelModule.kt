package com.xmartlabs.taskloans.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xmartlabs.taskloans.ui.login.LoginViewModel

import com.xmartlabs.taskloans.viewmodel.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
  @Binds
  @IntoMap
  @ViewModelKey(LoginViewModel::class)
  abstract fun bindLoginViewModel(userViewModel: LoginViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
