package com.skoda.tenderconnectivity.backendservice.prepaidservice.service.event;

import java.util.UUID;

public record ProlongEvent(Long userId, UUID prepaidServiceId) {
}
