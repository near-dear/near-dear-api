package io.neardear.api.authentication.infrastructure.security

import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

class CustomCorsFilter : CorsFilter(configurationSource()) {

    companion object {
        private fun configurationSource(): UrlBasedCorsConfigurationSource {
            val config = CorsConfiguration()
            config.allowCredentials = true
            config.allowedOriginPatterns = listOf("http://localhost:3000")
            config.addAllowedHeader("*")
            config.maxAge = 36000L
            config.allowedMethods = listOf("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
            val source = UrlBasedCorsConfigurationSource()
            source.registerCorsConfiguration("/**", config)
            source.registerCorsConfiguration("/v1/**", config)
            source.registerCorsConfiguration("/v1/auth/**", config)
            source.registerCorsConfiguration("/v1/user/**", config)
            source.registerCorsConfiguration("/v1/product/**", config)
            source.registerCorsConfiguration("/v1/merchant/**", config)
            return source
        }
    }
}