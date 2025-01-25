package com.ahad.location.server.service;

import com.ahad.location.server.request.location.LocationRequest;
import com.ahad.location.server.response.GenericResponse;
import com.ahad.location.server.response.location.LocationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@SpringBootTest
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    void findLocation() {
        Mono<GenericResponse<LocationResponse>> result = locationService.findLocation(new LocationRequest("client-1", "6596845976"));
        var body = result.block();
        System.out.println(body);
        Assert.isTrue("S200".equals(body.responseCode()), "No body");
    }
}
