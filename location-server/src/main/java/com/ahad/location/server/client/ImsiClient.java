package com.ahad.location.server.client;

import com.ahad.location.server.request.sigtran.SigtranImsiRequest;
import com.ahad.location.server.response.sigtran.SigtranImsiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ImsiClient {

    private final WebClient webClient;
    private final String imsiUri;


    public ImsiClient(WebClient webClient, @Value("${sigtran.api.request.imsi-uri}") String imsiUri) {
        this.webClient = webClient;
        this.imsiUri = imsiUri;
    }

    public Mono<String> getImsi(String clientId, String calledPartyPc, String calledPartyGt, String msisdn) {
        return webClient.post()
                .uri(imsiUri)
                .header("Content-Type", "application/json")
                .bodyValue(new SigtranImsiRequest(clientId, calledPartyPc, calledPartyGt, msisdn))
                .retrieve()
                .bodyToMono(SigtranImsiResponse.class)
                .map(SigtranImsiResponse::responseBody);
    }
}
