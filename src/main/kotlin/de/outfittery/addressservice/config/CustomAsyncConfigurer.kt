package de.outfittery.addressservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Component
import java.util.concurrent.Executor

@EnableAsync
@Configuration
class CustomAsyncConfigurer(private val customThreadPoolProperties: CustomThreadPoolProperties) : AsyncConfigurer {

    override fun getAsyncExecutor(): Executor? = ThreadPoolTaskExecutor().also {
        it.maxPoolSize = customThreadPoolProperties.max
        it.corePoolSize = customThreadPoolProperties.core
        it.initialize()
    }
}

@Component
@ConfigurationProperties(prefix = "custom-thread-pool")
data class CustomThreadPoolProperties(
        var max: Int = 0,
        var core: Int = 0
)