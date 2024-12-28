package com.ahad.location.server.controller;

import com.ahad.location.server.entity.ClientSpec;
import com.ahad.location.server.response.GenericResponse;
import com.ahad.location.server.service.ClientSpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/client-specs")

public class ClientSpecController {
    private final ClientSpecService service;

    public ClientSpecController(ClientSpecService service) {
        this.service = service;
    }

    @GetMapping
    public Mono<GenericResponse<List<ClientSpec>>> getAllClientSpecs() {
        return service.getAllClientSpecs();
    }
}