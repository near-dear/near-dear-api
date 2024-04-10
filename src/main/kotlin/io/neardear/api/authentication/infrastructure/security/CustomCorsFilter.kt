package io.neardear.api.authentication.infrastructure.security

import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

class CustomCorsFilter : CorsFilter(configurationSource()) {

    companion object {
        private fun configurationSource(): UrlBasedCorsConfigurationSource {
            val config = CorsConfiguration()
            config.allowCredentials = true
            config.allowedOriginPatterns = listOf("*")
            config.addAllowedHeader("*")
            config.maxAge = 36000L
            config.allowedMethods = listOf("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
            val source = UrlBasedCorsConfigurationSource()
            source.registerCorsConfiguration("/**", config)
            return source
        }
    }
}