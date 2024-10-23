package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;

import com.skoda.tenderconnectivity.backendservice.BackendServiceApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserPrepaidServiceControllerTest extends BackendServiceApplicationTests {


    @Test
    void testGetUserPrepaidServices_shouldOk() throws Exception {

        mockMvc.perform(get("/api/prepaid-services"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].serviceName").value("INFOTAINMENT_ONLINE"))
                .andExpect(jsonPath("$[0].expirationDate").value("2023-12-01"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].serviceName").value("REMOTE_ACCESS"))
                .andExpect(jsonPath("$[1].expirationDate").value("2023-11-15"));
    }
}
