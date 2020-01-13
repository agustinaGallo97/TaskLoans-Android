package com.xmartlabs.taskloans.extensions.ui

import androidx.viewpager.widget.ViewPager
import com.xmartlabs.taskloans.helper.EmptyOnPageChangeListener

fun ViewPager.nextPage() {
  currentItem++
}

fun ViewPager.isLastPage() = currentItem == (adapter?.let { adapter -> adapter.count - 1 })

inline fun ViewPager.onPageSelected(crossinline action: (position: Int) -> Unit) {
  addOnPageChangeListener(object : EmptyOnPageChangeListener() {
    override fun onPageSelected(position: Int) = action.invoke(position)
  })
}
