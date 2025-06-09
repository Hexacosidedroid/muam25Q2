package ru.cib.muamstart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class MuamStartApplication

fun main(args: Array<String>) {
    runApplication<MuamStartApplication>(*args)
}