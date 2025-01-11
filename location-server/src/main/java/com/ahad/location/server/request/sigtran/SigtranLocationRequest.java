package com.ahad.location.server.request.sigtran;

public record SigtranLocationRequest(
        String clientId,
        String calledPartyPc,
        String calledPartyGt,
        String imsi
) {
}