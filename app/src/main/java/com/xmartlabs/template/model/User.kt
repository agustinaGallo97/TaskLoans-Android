package com.xmartlabs.template.model

data class User(
    var id: Int? = 0,
    var name: String? = "",
    var email: String? = "",
    var tasks: List<Task>
)
