package com.ahad.location.server.controller;

import com.ahad.location.server.request.location.LocationRequest;
import com.ahad.location.server.response.GenericResponse;
import com.ahad.location.server.response.location.LocationResponse;
import com.ahad.location.server.service.LocationService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/location")

public class LocationController {
    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<GenericResponse<LocationResponse>> findLocation(@RequestBody LocationRequest locationRequest) {
        return service.findLocation(locationRequest);
    }
}