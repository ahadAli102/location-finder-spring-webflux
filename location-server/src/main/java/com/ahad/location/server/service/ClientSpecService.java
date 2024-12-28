package com.ahad.location.server.service;

import com.ahad.location.server.entity.ClientSpec;
import com.ahad.location.server.repository.ClientSpecRepository;
import com.ahad.location.server.response.GenericResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClientSpecService {
    private final ClientSpecRepository repository;

    public ClientSpecService(ClientSpecRepository repository) {
        this.repository = repository;
    }

    public Mono<GenericResponse<List<ClientSpec>>> getAllClientSpecs() {
        return repository.getAllClientSpecs()
                .collectList()
                .map(clientSpec -> new GenericResponse<>("D200", "Success", clientSpec))
                .onErrorResume(e -> Mono.just(new GenericResponse<>("D400", e.getMessage(), null)));
    }
}