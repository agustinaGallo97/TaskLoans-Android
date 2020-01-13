package com.xmartlabs.template.service.response

import com.xmartlabs.template.model.User

data class AuthResponse(
    val token: String,
    val user: User
)
