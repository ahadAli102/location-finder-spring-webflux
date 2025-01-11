package com.ahad.location.server.client;

import com.ahad.location.server.response.sigtran.SigtranLatLong;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@SpringBootTest
public class LocationClientTest {

    @Autowired
    private LocationClient locationClient;

    @Test
    void testLocation() {
        Mono<SigtranLatLong> result = locationClient.getLocation("test-client-01", "1120", "6596845976", "225036155555599");
        var body = result.block();
        Assert.notEmpty(new Object[]{body}, "No body");
    }
}
