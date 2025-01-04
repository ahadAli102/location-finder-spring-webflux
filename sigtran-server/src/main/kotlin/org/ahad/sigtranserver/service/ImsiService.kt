package org.ahad.sigtranserver.service

import org.ahad.sigtranserver.ImsiClient
import org.ahad.sigtranserver.request.ImsiRequest
import org.ahad.sigtranserver.response.GenericResponse
import org.springframework.stereotype.Service

@Service
class ImsiService(val imsiClient: ImsiClient) {

    fun getImsi(imsiRequest: ImsiRequest): GenericResponse<String> {
        return try {
            val imsi = imsiClient.getImsi(imsiRequest)
            GenericResponse("200", "Success", imsi.imsi)
        } catch (e: Exception) {
            GenericResponse("500", "Internal Server Error", "Error while fetching IMSI")
        }
    }
}