package org.ahad.sigtranserver

import org.ahad.sigtranserver.model.ImsiResponse
import org.ahad.sigtranserver.request.ImsiRequest
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger

@Service
class ImsiClient(val imsiDelays: List<Long>, val imsiResponses: List<ImsiResponse>) {

    val counter: AtomicInteger = AtomicInteger(0);

    fun getImsi(imsiRequest: ImsiRequest): ImsiResponse {
        return getDelayedImsi()
    }

    fun getDelayedImsi(): ImsiResponse {
        val delay = imsiDelays[counter.getAndIncrement() % imsiDelays.size]
        Thread.sleep(delay)
        return imsiResponses[counter.getAndIncrement() % imsiResponses.size]
    }
}