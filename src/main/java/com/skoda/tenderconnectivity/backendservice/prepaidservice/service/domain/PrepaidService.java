package com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Details of a prepaid service")
public record PrepaidService(
        @Schema(description = "Unique identifier of the service", example = "c56a4180-65aa-42ec-a945-5fd21dec0538")
        UUID id,

        @Schema(description = "Name of the prepaid service", example = "INFOTAINMENT_ONLINE")
        String serviceName,

        @Schema(description = "Description of the service", example = "Infotainment Online Service")
        String description
) {
}
