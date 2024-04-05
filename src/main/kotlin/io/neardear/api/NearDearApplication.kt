package io.neardear.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NearDearApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<NearDearApplication>(*args)
        }
    }
}
