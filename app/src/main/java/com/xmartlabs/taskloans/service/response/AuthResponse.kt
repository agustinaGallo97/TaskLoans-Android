package com.xmartlabs.taskloans.service.response

import com.xmartlabs.taskloans.model.User

data class AuthResponse(
    val token: String,
    val user: User
)
