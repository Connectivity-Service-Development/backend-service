package com.skoda.tenderconnectivity.backendservice.prepaidservice.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record UserPrepaidService(
        @Schema(description = "Details of a prepaid service for the user")
        Long id,
        @Schema(description = "Name of the prepaid service", example = "INFOTAINMENT_ONLINE")
        String serviceName,
        @Schema(description = "Expiration date of the service", example = "2023-12-01")
        LocalDate expirationDate
) {

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }
}
