package com.ahad.location.server.response.sigtran;

public record SigtranImsiResponse(
    String responseCode,
    String responseMessage,
    String responseBody
) {}
