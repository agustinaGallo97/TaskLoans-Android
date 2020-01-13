package com.xmartlabs.taskloans.ui.recyclerfragmentexample

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.fragmentargs.annotation.FragmentWithArgs
import com.xmartlabs.taskloans.R
import com.xmartlabs.taskloans.ui.common.TemplateFragment
import kotlinx.android.synthetic.main.fragment_recycler_example.*
import java.util.Locale

@FragmentWithArgs
class RecyclerExampleFragment : TemplateFragment() {
  override val isViewAlive: Boolean
    get() = TODO("not implemented") // To change initializer of created properties use File | Settings | File Templates.

  companion object {
    private const val LIST_COUNT = 39
  }

  @LayoutRes
  override val layoutResId = R.layout.fragment_recycler_example

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val strings = listOf(1..LIST_COUNT)
        .flatten()
        .map { String.format(Locale.getDefault(), "Item %d", it) }

    recyclerView.adapter = RecyclerExampleAdapter(strings)
    recyclerView.layoutManager = LinearLayoutManager(context)
  }
}
