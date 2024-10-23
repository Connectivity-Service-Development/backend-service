package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.domain.UserPrepaidService;
import com.skoda.tenderconnectivity.backendservice.prepaidservice.domain.UserServiceManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prepaid-services")
@RequiredArgsConstructor
public class UserPrepaidServiceController {

    private final UserServiceManager userServiceManager;

    @GetMapping
    @Operation(
            summary = "Get User Prepaid Services",
            description = "Fetch a list of prepaid services for the authenticated user along with their expiration details.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of user prepaid services",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserPrepaidService.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized - The user is not authenticated"
                    )
            }
    )
    public List<UserPrepaidService> getUserPrepaidServices(Authentication authentication) {
//        Long userId = (Long) authentication.getPrincipal();
        //since no real auth implement, hardcode the ID for demo purposes.
        Long userId = 1L;
        return userServiceManager.listUserPrepaidServices(userId);
    }
}
