package com.kr.krproject01.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // csrf 비활성화
            .authorizeHttpRequests {
                it.anyRequest().permitAll() // 모든 요청 허용
            }
            .formLogin { it.disable() } // 기본 로그인 화면 제거

        return http.build()
    }
}
