package com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.UUID;

public record UserPrepaidService(
        @Schema(description = "Unique identifier of prepaid service", example = "c56a4180-65aa-42ec-a945-5fd21dec0538")
        UUID prepaidServiceId,
        @Schema(description = "Name of the prepaid service", example = "INFOTAINMENT_ONLINE")
        String serviceName,
        @Schema(description = "Expiration date of the service", example = "2023-12-01")
        LocalDate expirationDate
) {

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }
}
