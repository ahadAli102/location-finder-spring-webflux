package com.ahad.location.server.client;

import com.ahad.location.server.request.sigtran.SigtranLocationRequest;
import com.ahad.location.server.response.sigtran.SigtranLatLong;
import com.ahad.location.server.response.sigtran.SigtranLocationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LocationClient {

    private final WebClient webClient;
    private final String imsiUri;


    public LocationClient(WebClient webClient, @Value("${sigtran.api.request.location-uri}") String locationUri) {
        this.webClient = webClient;
        this.imsiUri = locationUri;
    }

    public Mono<SigtranLatLong> getLocation(String clientId, String calledPartyPc, String calledPartyGt, String imsi) {
        return webClient.post()
                .uri(imsiUri)
                .header("Content-Type", "application/json")
                .bodyValue(new SigtranLocationRequest(clientId, calledPartyPc, calledPartyGt, imsi))
                .retrieve()
                .bodyToMono(SigtranLocationResponse.class)
                .map(SigtranLocationResponse::responseBody);
    }
}
