package com.ahad.location.server.repository;

import com.ahad.location.server.entity.ClientSpec;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;



@Repository
public class ClientSpecRepository {

    private final DatabaseClient databaseClient;

    public ClientSpecRepository(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Flux<ClientSpec> getAllClientSpecs() {
        return databaseClient.sql("SELECT * FROM client_spec")
                .map((row, metadata) -> new ClientSpec(row.get("name", String.class), row.get("pc", String.class), row.get("gt", String.class)))
                .all();
    }
}