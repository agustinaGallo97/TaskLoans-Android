package com.xmartlabs.taskloans.model

import com.xmartlabs.bigbang.core.model.SessionType

data class Session(override var accessToken: String? = null) : SessionType
