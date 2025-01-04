package org.ahad.sigtranserver.request

data class LocationRequest(
    val clientId: String,
    val calledPartyPc: Int,
    val calledPartyGt: String,
    val imsi: String
)