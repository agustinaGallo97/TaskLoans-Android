package com.xmartlabs.template.model

data class Balance(
    var user: User? = null,
    var favour: Int = 0,
    var against: Int = 0
)
