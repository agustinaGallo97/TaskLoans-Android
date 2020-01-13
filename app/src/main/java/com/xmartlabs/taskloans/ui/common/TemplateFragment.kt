package com.xmartlabs.taskloans.ui.common

import androidx.annotation.StringRes
import com.afollestad.materialdialogs.MaterialDialog
import com.xmartlabs.bigbang.ui.BaseFragment
import com.xmartlabs.taskloans.R
import io.reactivex.exceptions.CompositeException
import java.io.IOException
import java.util.concurrent.CancellationException

abstract class TemplateFragment : BaseFragment(), ErrorHandlerView {
  fun showError(@StringRes message: Int, @StringRes title: Int, @StringRes buttonTitle: Int) {
    context?.let {
      MaterialDialog.Builder(it)
          .title(title)
          .content(message)
          .positiveText(buttonTitle)
          .build()
          .show()
    }
  }

  override fun showError(error: Throwable, @StringRes message: Int?) {
    if (error is CancellationException) {
      return
    }

    var receiverError = error
    if (receiverError is CompositeException) {
      receiverError = receiverError.exceptions[0]
    }
    if (receiverError is IOException) {
      showError(R.string.check_your_internet_connection, R.string.no_internet_connection, android.R.string.ok)
    } else if (message == null) {
      showError(R.string.error_service_call_generic, R.string.error_service_call_generic, android.R.string.ok)
    } else {
      showError(message, R.string.error, android.R.string.ok)
    }
  }
}
