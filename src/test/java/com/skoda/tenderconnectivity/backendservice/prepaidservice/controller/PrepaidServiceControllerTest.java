package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;

import com.skoda.tenderconnectivity.backendservice.BackendServiceApplicationTests;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PrepaidServiceControllerTest extends BackendServiceApplicationTests {

    @Autowired
    EntityManager entityManager;


    @Test
    void testGetUserPrepaidServices_shouldOk() throws Exception {

        mockMvc.perform(get("/api/prepaid-services/user"))
                .andDo(print())
                .andExpect(status().isOk())
                // First Service
                .andExpect(jsonPath("$[0].prepaidServiceId").isString())
                .andExpect(jsonPath("$[0].serviceName").value("INFOTAINMENT_ONLINE"))
                .andExpect(jsonPath("$[0].expirationDate").value("2024-11-01"))
                .andExpect(jsonPath("$[0].expired").value(false))
                // Second Service
                .andExpect(jsonPath("$[1].prepaidServiceId").isString())
                .andExpect(jsonPath("$[1].serviceName").value("INTELLIGENT_SPEED_ASSIST"))
                .andExpect(jsonPath("$[1].expirationDate").value("2023-11-15"))
                .andExpect(jsonPath("$[1].expired").value(true));

    }

    @Test
    void testAllPrepaidServices_shouldOk() throws Exception {
        mockMvc.perform(get("/api/prepaid-services/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isString())
                .andExpect(jsonPath("$[0].serviceName").value("INFOTAINMENT_ONLINE"))
                .andExpect(jsonPath("$[0].description").value("Infotainment Online Service"))
                .andExpect(jsonPath("$[1].id").isString())
                .andExpect(jsonPath("$[1].serviceName").value("REMOTE_ACCESS"))
                .andExpect(jsonPath("$[1].description").value("Remote Access Service"))
                .andExpect(jsonPath("$[2].id").isString())
                .andExpect(jsonPath("$[2].serviceName").value("TRAVEL_ASSIST"))
                .andExpect(jsonPath("$[2].description").value("Online data for Travel Assist"))
                .andExpect(jsonPath("$[3].id").isString())
                .andExpect(jsonPath("$[3].serviceName").value("MEDIA_STREAMING"))
                .andExpect(jsonPath("$[3].description").value("Media Streaming Service"))
                .andExpect(jsonPath("$[4].id").isString())
                .andExpect(jsonPath("$[4].serviceName").value("INTELLIGENT_SPEED_ASSIST"))
                .andExpect(jsonPath("$[4].description").value("Online data for Intelligent Speed Assist"))
                .andExpect(jsonPath("$[5].id").isString())
                .andExpect(jsonPath("$[5].serviceName").value("TRAFFICATION"))
                .andExpect(jsonPath("$[5].description").value("Traffication Service"));
    }

    @Test
    void testProlongPrepaidService_shouldReturnNoContent() throws Exception {
        // Mocking the event publisher to do nothing when publishEvent is called
        doNothing().when(eventPublisher).publishEvent(any());

        // Create a sample UUID for the service ID
        UUID serviceId = UUID.randomUUID();

        // Prepare JSON request body
        String requestBody = String.format("{\"serviceId\": \"%s\"}", serviceId);

        // Perform POST request and verify the response
        mockMvc.perform(post("/api/prepaid-services/prolong")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isNoContent()); // Expect 204 No Content
    }

}
