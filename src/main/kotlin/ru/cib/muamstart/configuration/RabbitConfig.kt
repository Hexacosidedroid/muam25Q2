package ru.cib.muamstart.configuration

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitConfig(
    @Value("\${rabbit.test.queue}")
    private val queue: String
) {

    @Bean
    fun myQueueTest() = Queue(queue, false)

    @Bean
    fun jsonMessageConverter() = Jackson2JsonMessageConverter()
}