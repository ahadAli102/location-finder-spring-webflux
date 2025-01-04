package org.ahad.sigtranserver.model

data class LocationResponse(
    val latitude: Double,
    val longitude: Double,
    val responseCode: String,
    val responseMessage: String
)