package com.xmartlabs.template.service.response

import com.xmartlabs.template.model.User

data class UserResponse(
    var token: String? = null,
    var user: User? = null
)
