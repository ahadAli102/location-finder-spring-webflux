package org.ahad.sigtranserver.request

data class ImsiRequest(
    val clientId: String,
    val calledPartyPc: String,
    val calledPartyGt: String,
    val msisdn: String
)