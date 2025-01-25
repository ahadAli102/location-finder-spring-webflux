package com.ahad.location.server.service;

import com.ahad.location.server.client.ImsiClient;
import com.ahad.location.server.client.LocationClient;
import com.ahad.location.server.repository.ClientSpecRepository;
import com.ahad.location.server.request.location.LocationRequest;
import com.ahad.location.server.response.GenericResponse;
import com.ahad.location.server.response.location.LocationResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class LocationService {
    private final ClientSpecRepository repository;
    private final ImsiClient imsiClient;
    private final LocationClient locationClient;

    public LocationService(ClientSpecRepository repository, ImsiClient imsiClient, LocationClient locationClient) {
        this.repository = repository;
        this.imsiClient = imsiClient;
        this.locationClient = locationClient;
    }


    public Mono<GenericResponse<LocationResponse>> findLocation(LocationRequest locationRequest) {

        return repository.getClientSpec(locationRequest.clientName())
                .flatMap(clientSpec -> imsiClient.getImsi(clientSpec.name(), clientSpec.pc(), clientSpec.gt(), locationRequest.msisdn())
                        .flatMap(imsi -> locationClient.getLocation(clientSpec.name(), clientSpec.pc(), clientSpec.gt(), imsi)
                                .map(location -> new GenericResponse<>("S200", "Success", new LocationResponse(location.latitude(), location.longitude())))
                        )
                )
                .onErrorReturn(new GenericResponse<>("S500", "Internal Server Error", null))
                .switchIfEmpty(Mono.just(new GenericResponse<>("S404", "Client not found", null)));
    }
}