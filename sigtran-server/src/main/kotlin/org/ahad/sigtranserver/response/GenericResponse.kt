package org.ahad.sigtranserver.response

data class GenericResponse<T>(
    val responseCode: String,
    val responseMessage: String,
    val responseBody: T
)