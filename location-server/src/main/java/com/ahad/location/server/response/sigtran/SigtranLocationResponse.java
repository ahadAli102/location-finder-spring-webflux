package com.ahad.location.server.response.sigtran;

public record SigtranLocationResponse(
    String responseCode,
    String responseMessage,
    SigtranLatLong responseBody
) {}
