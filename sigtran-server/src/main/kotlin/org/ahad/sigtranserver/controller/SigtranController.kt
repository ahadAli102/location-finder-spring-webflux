package org.ahad.sigtranserver.controller

import org.ahad.sigtranserver.request.ImsiRequest
import org.ahad.sigtranserver.response.GenericResponse
import org.ahad.sigtranserver.service.ImsiService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sigtran-api")
class SigtranController (val imsiService: ImsiService) {

    @PostMapping("/imsi")
    fun getImsi(@RequestBody imsiRequest: ImsiRequest): GenericResponse<String> {
        return imsiService.getImsi(imsiRequest)
    }
}