package com.skoda.tenderconnectivity.backendservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.mock;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Import(MockitoPublisherConfiguration.class)
public abstract class BackendServiceApplicationTests {
    @Autowired
    protected MockMvc mockMvc;
    @MockBean
    protected ApplicationEventPublisher eventPublisher;


}

@TestConfiguration
class MockitoPublisherConfiguration {

    @Bean
    @Primary
    ApplicationEventPublisher publisher() {
        return mock(ApplicationEventPublisher.class);
    }
}
