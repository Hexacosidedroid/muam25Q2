package ru.cib.muamstart.service

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service
import ru.cib.muamstart.dao.Product

@Service
class ReceiveDataFromRabbit {

    @RabbitListener(queues = ["test123"])
    fun rabbitTestListener(product: Product) {
        println(product)
    }
}