package com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record ProlongRequest(
        @Schema(description = "UUID of the prepaid service to prolong", example = "c6d01a68-1014-4475-be25-b575e0f13f2d")
        UUID serviceId
) {
}
