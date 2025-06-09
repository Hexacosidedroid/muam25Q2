package ru.cib.muamstart.service

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class SendDataToRabbit(
    private val rabbitTemplate: RabbitTemplate,
    private val productService: ProductService,
    @Value("\${rabbit.test.queue}")
    private val queue: String
) {
    @Scheduled(fixedDelay = 60000)
    fun sendData() {
        val result = productService.getAllListOfProducts()
        rabbitTemplate.convertAndSend(queue, result[0])
    }
}