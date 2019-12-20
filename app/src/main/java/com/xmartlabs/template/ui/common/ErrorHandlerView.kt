package com.xmartlabs.template.ui.common

import androidx.annotation.StringRes

interface ErrorHandlerView {
  val isViewAlive: Boolean
  fun showError(throwable: Throwable, @StringRes errorMessage: Int?)
}
