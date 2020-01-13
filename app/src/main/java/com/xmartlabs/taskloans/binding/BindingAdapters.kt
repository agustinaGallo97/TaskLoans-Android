package com.xmartlabs.taskloans.binding

import androidx.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.xmartlabs.taskloans.App

/**
 * Data Binding adapters specific to the app.
 */
object BindingAdapters {
  @BindingAdapter("visibleGone")
  @JvmStatic
  fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
  }

  @BindingAdapter("imageUrl")
  @JvmStatic
  fun imageUrl(imageView: ImageView, url: String?) {
    url.let {
      Picasso.with(App.context)
          .load(url)
          .into(imageView)
    }
  }
}
