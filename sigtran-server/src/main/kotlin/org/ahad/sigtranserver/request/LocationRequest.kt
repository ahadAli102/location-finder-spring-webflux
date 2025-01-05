package org.ahad.sigtranserver.request

data class LocationRequest(
    val clientId: String,
    val calledPartyPc: String,
    val calledPartyGt: String,
    val imsi: String
)