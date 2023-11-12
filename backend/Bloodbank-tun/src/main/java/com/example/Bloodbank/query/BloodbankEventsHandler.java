package com.example.Bloodbank.query;

import com.example.Bloodbank.core.data.BloodbankEntity;
import com.example.Bloodbank.core.data.BloodbankRepository;
import com.example.Bloodbank.core.events.BloodbankCreatedEvent;
import com.example.Bloodbank.core.events.BloodbankUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BloodbankEventsHandler {
    private final BloodbankRepository bloodbankRepository;

    public BloodbankEventsHandler(BloodbankRepository bloodbankRepository) {
        this.bloodbankRepository = bloodbankRepository;
    }

    @EventHandler
    public void onCreate(BloodbankCreatedEvent event) {
        BloodbankEntity bloodbankEntity = new BloodbankEntity();
        BeanUtils.copyProperties(event, bloodbankEntity);
        System.out.println(event);
        bloodbankRepository.save(bloodbankEntity);
    }

    @EventHandler
    public void onUpdate(BloodbankUpdatedEvent event) {
        BloodbankEntity bloodbankEntity = new BloodbankEntity();
        BeanUtils.copyProperties(event, bloodbankEntity);
        bloodbankRepository.save(bloodbankEntity);
    }
}
