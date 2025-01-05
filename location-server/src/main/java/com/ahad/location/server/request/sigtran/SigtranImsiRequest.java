package com.ahad.location.server.request.sigtran;

public record SigtranImsiRequest(
    String clientId,
    String calledPartyPc,
    String calledPartyGt,
    String msisdn
) {}