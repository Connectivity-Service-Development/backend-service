package com.skoda.tenderconnectivity.backendservice.prepaidservice.controller;

import com.skoda.tenderconnectivity.backendservice.BackendServiceApplicationTests;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

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
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())

                // First Service: INFOTAINMENT_ONLINE
                .andExpect(jsonPath("$[0].id").isString())
                .andExpect(jsonPath("$[0].serviceName").value("INFOTAINMENT_ONLINE"))
                .andExpect(jsonPath("$[0].description").value("The Infotainment Online Service provides seamless access to music, podcasts, and live streaming, ensuring an enjoyable driving experience. Stay informed with real-time traffic updates, news, and weather reports, all integrated into your vehicle’s dashboard. Connect your favorite apps for hands-free control and navigate effortlessly using advanced voice recognition features."))
                .andExpect(jsonPath("$[0].price").value(9.99))
                .andExpect(jsonPath("$[0].bulletPoints[0]").value("Stream music and podcasts"))
                .andExpect(jsonPath("$[0].bulletPoints[1]").value("Get live traffic updates"))
                .andExpect(jsonPath("$[0].bulletPoints[2]").value("Access news and weather reports"))
                .andExpect(jsonPath("$[0].bulletPoints[3]").value("Connect apps for hands-free control"))
                .andExpect(jsonPath("$[0].bulletPoints[4]").value("Voice control for easy navigation"))

                // Second Service: REMOTE_ACCESS
                .andExpect(jsonPath("$[1].id").isString())
                .andExpect(jsonPath("$[1].serviceName").value("REMOTE_ACCESS"))
                .andExpect(jsonPath("$[1].description").value("Remote Access Service allows you to stay connected with your vehicle, no matter where you are. Easily check and share your parking position, record and analyze your driving data, and manage a digital logbook to keep track of all your journeys. Control essential vehicle functions, schedule maintenance, and receive timely alerts for optimal performance, helping you save on fuel costs."))
                .andExpect(jsonPath("$[1].price").value(7.99))
                .andExpect(jsonPath("$[1].bulletPoints[0]").value("See and share your parking position"))
                .andExpect(jsonPath("$[1].bulletPoints[1]").value("Record all your driving data"))
                .andExpect(jsonPath("$[1].bulletPoints[2]").value("Manage your digital logbook"))
                .andExpect(jsonPath("$[1].bulletPoints[3]").value("Control your vehicle’s service needs"))
                .andExpect(jsonPath("$[1].bulletPoints[4]").value("Optimize your fuel costs"))
                .andExpect(jsonPath("$[1].bulletPoints[5]").value("And much more"))

                // Third Service: TRAVEL_ASSIST
                .andExpect(jsonPath("$[2].id").isString())
                .andExpect(jsonPath("$[2].serviceName").value("TRAVEL_ASSIST"))
                .andExpect(jsonPath("$[2].description").value("Travel Assist provides comprehensive support for your road trips, offering real-time route planning and navigation assistance. It finds the fastest and most efficient routes based on live traffic conditions, helping you avoid congestion and roadblocks. With access to live road condition alerts, you can plan your stops for rest areas and refueling, making long journeys safer and more convenient."))
                .andExpect(jsonPath("$[2].price").value(5.99))
                .andExpect(jsonPath("$[2].bulletPoints[0]").value("Real-time route planning"))
                .andExpect(jsonPath("$[2].bulletPoints[1]").value("Find the fastest alternative routes"))
                .andExpect(jsonPath("$[2].bulletPoints[2]").value("Access live road condition alerts"))
                .andExpect(jsonPath("$[2].bulletPoints[3]").value("Receive real-time traffic congestion updates"))
                .andExpect(jsonPath("$[2].bulletPoints[4]").value("Plan stops for rest areas and refueling"))

                // Fourth Service: MEDIA_STREAMING
                .andExpect(jsonPath("$[3].id").isString())
                .andExpect(jsonPath("$[3].serviceName").value("MEDIA_STREAMING"))
                .andExpect(jsonPath("$[3].description").value("Media Streaming Service transforms your vehicle into a mobile entertainment hub, allowing seamless streaming of video, music, and other media. With support for multiple platforms, it ensures high-quality playback even on long drives, and allows multiple devices to connect simultaneously. Enjoy buffer-free streaming, whether you are listening to your favorite playlists or watching shows on the go."))
                .andExpect(jsonPath("$[3].price").value(8.49))
                .andExpect(jsonPath("$[3].bulletPoints[0]").value("Stream video and music seamlessly"))
                .andExpect(jsonPath("$[3].bulletPoints[1]").value("Supports multiple media platforms"))
                .andExpect(jsonPath("$[3].bulletPoints[2]").value("High-quality audio and video"))
                .andExpect(jsonPath("$[3].bulletPoints[3]").value("Buffer-free playback during trips"))
                .andExpect(jsonPath("$[3].bulletPoints[4]").value("Connect multiple devices at once"))

                // Fifth Service: INTELLIGENT_SPEED_ASSIST
                .andExpect(jsonPath("$[4].id").isString())
                .andExpect(jsonPath("$[4].serviceName").value("INTELLIGENT_SPEED_ASSIST"))
                .andExpect(jsonPath("$[4].description").value("Intelligent Speed Assist helps you stay safe on the road by automatically detecting speed limits and providing timely alerts. It adjusts in real-time to road conditions, ensuring that you drive within safe speed limits, minimizing the risk of speeding violations. This service is designed to assist with smooth and efficient driving, giving you more control over your journey."))
                .andExpect(jsonPath("$[4].price").value(6.99))
                .andExpect(jsonPath("$[4].bulletPoints[0]").value("Automatic speed limit detection"))
                .andExpect(jsonPath("$[4].bulletPoints[1]").value("Speed alerts based on location"))
                .andExpect(jsonPath("$[4].bulletPoints[2]").value("Reduce risk of speeding violations"))
                .andExpect(jsonPath("$[4].bulletPoints[3]").value("Real-time adjustments based on road conditions"))
                .andExpect(jsonPath("$[4].bulletPoints[4]").value("Assist with safe and efficient driving"))

                // Sixth Service: TRAFFICATION
                .andExpect(jsonPath("$[5].id").isString())
                .andExpect(jsonPath("$[5].serviceName").value("TRAFFICATION"))
                .andExpect(jsonPath("$[5].description").value("Traffication Service keeps you informed about traffic conditions in real-time, providing alerts on nearby hazards, sudden changes in traffic, and road closures. It helps you plan your route to minimize delays, suggesting alternatives to keep your journey as smooth as possible. Stay updated on the road with accurate, real-time traffic density information, making your commute less stressful."))
                .andExpect(jsonPath("$[5].price").value(4.99))
                .andExpect(jsonPath("$[5].bulletPoints[0]").value("Receive alerts for nearby hazards"))
                .andExpect(jsonPath("$[5].bulletPoints[1]").value("Get notified of sudden traffic changes"))
                .andExpect(jsonPath("$[5].bulletPoints[2]").value("Stay updated on road closures and diversions"))
                .andExpect(jsonPath("$[5].bulletPoints[3]").value("Minimize travel delays with route suggestions"))
                .andExpect(jsonPath("$[5].bulletPoints[4]").value("Real-time traffic density updates"));
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
