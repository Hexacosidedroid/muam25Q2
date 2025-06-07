package ru.cib.muamstart.configuration

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.disable
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.security.web.context.HttpSessionSecurityContextRepository
import org.springframework.web.cors.CorsConfiguration

@Configuration
@EnableWebSecurity
class SecurityConfiguration() {


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        val entryPoint = BasicAuthenticationEntryPoint()
        entryPoint.realmName = "localhost"
        return http
            .csrf { disable() }
            .cors {
                CorsConfiguration().apply {
                    addAllowedOriginPattern("*")
                    addAllowedMethod("*")
                    addAllowedHeader("*")
                    allowCredentials = true
                }
            }
            .sessionManagement {
                it
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            }
            .httpBasic {
                it
                    .securityContextRepository(HttpSessionSecurityContextRepository())
                    .realmName("localhost")
                    .authenticationEntryPoint(entryPoint)
                    .authenticationDetailsSource(WebAuthenticationDetailsSource())
            }
            .authorizeHttpRequests {
                it.anyRequest().authenticated()
            }
            .build()
    }

    @Bean
    fun inMemoryAuth(): InMemoryUserDetailsManager {
        val user = User
            .builder()
            .username("user")
            .password("{noop}password")
            .roles("USER")
            .build()
        return InMemoryUserDetailsManager(user)
    }
}