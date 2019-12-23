package com.xmartlabs.template.helper

import androidx.annotation.CheckResult
import androidx.annotation.StringRes
import com.xmartlabs.template.ui.common.ErrorHandlerView
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

open class GeneralSingleSubscriber<T> constructor(errorHandlerView: ErrorHandlerView? = null) : SingleObserver<T> {
  private val viewReference = WeakReference<ErrorHandlerView>(errorHandlerView)

  override fun onSubscribe(disposable: Disposable) {}

  override fun onError(throwable: Throwable) {
    val view = viewReference.get()
    if (alertOnError(throwable) && view != null && view.isViewAlive) {
      view.showError(throwable, getErrorMessage(throwable))
    }
  }

  override fun onSuccess(t: T) {}

  @StringRes
  protected open fun getErrorMessage(throwable: Throwable): Int? = null

  @CheckResult
  protected open fun alertOnError(throwable: Throwable) = true
}
