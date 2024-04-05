package io.neardear.api.authentication.infrastructure

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors { it.disable() }
            .sessionManagement { it.disable() }
            .authorizeHttpRequests { configurer ->
                configurer.anyRequest().permitAll() // TODO mock api 작성 이후에 api endpoint 인가 설정 적용하기
            }
            .formLogin { it.disable() }
            .build()
    }
}