package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;

import com.skoda.tenderconnectivity.backendservice.BackendServiceApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PrepaidServiceControllerTest extends BackendServiceApplicationTests {


    @Test
    void testGetUserPrepaidServices_shouldOk() throws Exception {

        mockMvc.perform(get("/api/prepaid-services/user"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                // First Service
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].serviceName").value("INFOTAINMENT_ONLINE"))
                .andExpect(jsonPath("$[0].expirationDate").value("2024-11-01"))
                .andExpect(jsonPath("$[0].expired").value(false))
                // Second Service
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].serviceName").value("INTELLIGENT_SPEED_ASSIST"))
                .andExpect(jsonPath("$[1].expirationDate").value("2023-11-15"))
                .andExpect(jsonPath("$[1].expired").value(true));

    }

    @Test
    void testAllPrepaidServices_shouldOk() throws Exception {
        mockMvc.perform(get("/api/prepaid-services/all"))
                .andDo(MockMvcResultHandlers.print())
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
}
