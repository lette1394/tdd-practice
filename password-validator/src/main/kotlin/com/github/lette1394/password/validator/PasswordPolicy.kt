package com.github.lette1394.password.validator

import arrow.core.Either

fun interface PasswordPolicy {
    fun matches(value: String): Either<Reasons, Unit>
}
