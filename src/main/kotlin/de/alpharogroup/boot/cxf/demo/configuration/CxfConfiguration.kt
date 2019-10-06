package de.alpharogroup.boot.cxf.demo.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.apache.cxf.Bus
import org.springframework.context.annotation.Bean
import org.apache.cxf.endpoint.Server
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean
import org.apache.cxf.jaxrs.swagger.Swagger2Feature
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider
import de.alpharogroup.boot.cxf.demo.controller.BroController
import de.alpharogroup.boot.cxf.demo.entity.BroRepository
import de.alpharogroup.boot.cxf.demo.service.BroService

@Configuration
class CxfConfiguration @Autowired constructor(val bus: Bus){

    @Autowired
    lateinit var broRepository: BroRepository

    @Bean
    fun rsServer(): Server {
        val jacksonJsonProvider = jacksonJsonProvider()
        val swagger2Feature = Swagger2Feature()
        val endpoint = JAXRSServerFactoryBean()
        endpoint.setProvider(jacksonJsonProvider)
        endpoint.setBus(bus)
        endpoint.setFeatures(listOf(swagger2Feature))
        return endpoint.create()
    }

    @Bean
    fun jacksonJsonProvider(): JacksonJsonProvider {
        val jacksonJsonProvider = JacksonJsonProvider()
        return jacksonJsonProvider
    }

    @Bean
    fun broController(): BroController {
        return BroController(broService())
    }

    @Bean
    fun broService(): BroService {
        return BroService(broRepository)
    }
}