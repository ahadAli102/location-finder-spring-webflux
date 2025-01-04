package org.ahad.sigtranserver.service

import org.ahad.sigtranserver.client.LocationClient
import org.ahad.sigtranserver.request.LocationRequest
import org.ahad.sigtranserver.response.GenericResponse
import org.ahad.sigtranserver.response.LatLong
import org.springframework.stereotype.Service

@Service
class LocationService(val locationClient: LocationClient) {

    fun getLocation(locationRequest: LocationRequest): GenericResponse<LatLong?> {
        return try {
            val location = locationClient.getLocation(locationRequest)
            GenericResponse("200", "Success", LatLong(location.latitude, location.longitude))
        } catch (e: Exception) {
            GenericResponse("500", "Internal Server Error", null)
        }
    }
}