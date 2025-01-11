package org.ahad.sigtranserver.client

import org.ahad.sigtranserver.model.LocationResponse
import org.ahad.sigtranserver.request.LocationRequest
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger

@Service
class LocationClient(val locationDelays: List<Long>, val locationResponses: List<LocationResponse>) {

    val counter: AtomicInteger = AtomicInteger(0);

    fun getLocation(locationRequest: LocationRequest): LocationResponse {
        return getDelayedLocation()
    }

    fun getDelayedLocation(): LocationResponse {
        val delay = locationDelays[counter.get() % locationDelays.size]
        Thread.sleep(delay)
        return locationResponses[counter.getAndIncrement() % locationResponses.size]
    }
}