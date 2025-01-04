package org.ahad.sigtranserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SigtranServerApplication

fun main(args: Array<String>) {
    runApplication<SigtranServerApplication>(*args)
}
