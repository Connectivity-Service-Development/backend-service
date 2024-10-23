package com.skoda.tenderconnectivity.backendservice.prepaidservice.service.event;

import com.skoda.tenderconnectivity.backendservice.prepaidservice.service.UserPrepaidServiceProlongation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProlongEventListener {

    private final UserPrepaidServiceProlongation userPrepaidServiceProlongation;

    /**
     * In reality this event listener would wait for payment to be finished. Since this is a demo the transaction will be completed immediately
     */
    @EventListener
    void prolongUserPrepaidService(ProlongEvent event) {
        userPrepaidServiceProlongation.prolongUserPrepaidService(event.userId(), event.prepaidServiceId());
    }
}
