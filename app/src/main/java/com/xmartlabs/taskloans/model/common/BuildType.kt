package com.xmartlabs.taskloans.model.common

import java.util.Locale

enum class BuildType {
  STAGING,
  PRODUCTION,
  ;

  override fun toString() = name.toLowerCase(Locale.getDefault())
}
