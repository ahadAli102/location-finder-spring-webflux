package com.ahad.location.server.configuration;

import io.netty.handler.logging.LogLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.time.Duration;

@Configuration
public class BeanConfiguration {

    @Value("${sigtran.api.base-url}")
    private String sigtranApiBaseUrl;

    @Value("${sigtran.api.request.timeout}")
    private long timeout;

    @Value("${sigtran.api.max-connections}")
    private int maxConnection;


    @Bean
    public WebClient webClient() {
        ConnectionProvider provider = ConnectionProvider.builder("sigtran-api")
                .maxConnections(maxConnection)
                .build();
        HttpClient httpClient = HttpClient.create(provider)
                .responseTimeout(Duration.ofMillis(timeout))
                .wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
        return WebClient.builder()
                .baseUrl(sigtranApiBaseUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}