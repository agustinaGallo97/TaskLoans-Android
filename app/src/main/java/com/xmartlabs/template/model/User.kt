package com.xmartlabs.template.model

data class User(
    var id: String = "",
    var name: String = "",
    var email: String = "",
    var tasks: List<Task>
)
