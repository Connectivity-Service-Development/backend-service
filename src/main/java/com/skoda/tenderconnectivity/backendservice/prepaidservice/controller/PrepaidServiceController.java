package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.PrepaidServiceFinder;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.UserServiceManager;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.PrepaidService;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.ProlongRequest;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.domain.UserPrepaidService;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.event.ProlongEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prepaid-services")
@RequiredArgsConstructor
@Tag(name = "Prepaid Services", description = "API for managing and retrieving prepaid services")
public class PrepaidServiceController {

    private final UserServiceManager userServiceManager;
    private final PrepaidServiceFinder prepaidServiceFinder;
    private final ApplicationEventPublisher eventPublisher;

    @GetMapping("/user")
    @Operation(
            summary = "Get User Prepaid Services",
            description = "Fetch a list of prepaid services for the authenticated user along with their expiration details.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of user prepaid services"
                    ),
            }
    )
    public List<UserPrepaidService> getUserPrepaidServices(Authentication authentication) {
        //since no real auth implemented, hardcode the ID for demo purposes.
        Long userId = 1L;
        return userServiceManager.listUserPrepaidServices(userId);
    }


    @GetMapping("/all")
    @Operation(
            summary = "Get All Prepaid Services",
            description = "Retrieve a list of all available prepaid services.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved list of prepaid services"
                    ),
            }
    )
    public List<PrepaidService> getAllPrepaidServices() {
        return prepaidServiceFinder.getAllPrepaidServices();
    }


    @PostMapping("/prolong")
    @Operation(
            summary = "Request to Prolong Prepaid Service",
            description = "Simulates a request to prolong the expiration date of a prepaid service for the user."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Prolongation request successful"),
    })
    public ResponseEntity<Void> prolongPrepaidService(@RequestBody ProlongRequest request) {
        var fakeUserId = 1L;
        eventPublisher.publishEvent(new ProlongEvent(fakeUserId, request.serviceId()));
        return ResponseEntity.noContent().build();
    }
}
