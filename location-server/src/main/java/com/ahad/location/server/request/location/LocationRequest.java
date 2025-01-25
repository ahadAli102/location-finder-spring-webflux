package com.ahad.location.server.request.location;

public record LocationRequest(
        String clientName,
        String msisdn
) {
}
