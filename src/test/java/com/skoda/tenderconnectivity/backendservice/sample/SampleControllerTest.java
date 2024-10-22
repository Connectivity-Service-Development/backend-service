package com.skoda.tenderconnectivity.backendservice.sample;

import com.skoda.tenderconnectivity.backendservice.BackendServiceApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class SampleControllerTest extends BackendServiceApplicationTests {

    @Test
    void getSample_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/sample"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.description").value("description"))
                .andExpect(jsonPath("$.publicId").isString())
        ;
    }

}
