package org.ahad.sigtranserver.configuration

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.ahad.sigtranserver.model.ImsiResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
class BeanConfiguration {

    @Value("\${response.imsi.delays}")
    val imsiDelays: String = ""
    @Value("\${response.imsi.file}")
    val imsiResponseFilePath: String = ""

    @Bean
    fun imsiDelays(): List<Long> {
        return try {
            imsiDelays.split(",")
                .map { it.trim() }
                .map { it.toLong() }
                .toList()
        } catch (e: Exception) {
            listOf(0, 1000, 2000, 0, 4000, 5000)
        }
    }

    @Bean
    fun imsiResponses(): List<ImsiResponse> {
        val objectMapper = jacksonObjectMapper()
        val file = File(imsiResponseFilePath)
        return objectMapper.readValue(file, objectMapper.typeFactory.constructCollectionType(List::class.java, ImsiResponse::class.java))
    }
}