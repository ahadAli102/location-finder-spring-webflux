package org.ahad.sigtranserver.controller

import org.ahad.sigtranserver.request.ImsiRequest
import org.ahad.sigtranserver.request.LocationRequest
import org.ahad.sigtranserver.response.GenericResponse
import org.ahad.sigtranserver.response.LatLong
import org.ahad.sigtranserver.service.ImsiService
import org.ahad.sigtranserver.service.LocationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sigtran-api")
class SigtranController(
    val imsiService: ImsiService,
    private val locationService: LocationService,
    service: LocationService
) {

    @PostMapping("/imsi")
    fun getImsi(@RequestBody imsiRequest: ImsiRequest): GenericResponse<String> {
        return imsiService.getImsi(imsiRequest)
    }

    @PostMapping("/location")
    fun getImsi(@RequestBody locationRequest: LocationRequest): GenericResponse<LatLong?> {
        return locationService.getLocation(locationRequest)
    }
}