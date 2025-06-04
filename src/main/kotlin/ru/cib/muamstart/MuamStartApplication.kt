package ru.cib.muamstart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MuamStartApplication

fun main(args: Array<String>) {
    runApplication<MuamStartApplication>(*args)
}