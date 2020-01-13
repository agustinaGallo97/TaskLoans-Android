package com.xmartlabs.taskloans.helper

import androidx.viewpager.widget.ViewPager

open class EmptyOnPageChangeListener : ViewPager.OnPageChangeListener {
  override fun onPageScrollStateChanged(state: Int) = Unit
  override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit
  override fun onPageSelected(position: Int) = Unit
}
