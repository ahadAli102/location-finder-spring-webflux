package com.ahad.location.server.client;

import com.ahad.location.server.response.sigtran.SigtranImsiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@SpringBootTest
public class ImsiClientTest {

    @Autowired
    private ImsiClient imsiClient;

    @Test
    void testGetImsi() {
        Mono<String> result = imsiClient.getImsi("clientId", "calledPartyPc", "calledPartyGt", "msisdn");
        var body = result.block();
        Assert.hasText(body, "Body should not be empty");
    }
}
