package com.example.Bloodbank.query.rest;

import com.example.Bloodbank.core.data.BloodbankEntity;
import com.example.Bloodbank.core.data.BloodbankRepository;
import com.example.Bloodbank.query.FindBloodbankByIdQuery;
import com.example.Bloodbank.query.FindBloodbankQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BloodbankQueryHandler {
    private final BloodbankRepository bloodbankRepository;

    public BloodbankQueryHandler(BloodbankRepository bloodbankRepository){
        this.bloodbankRepository = bloodbankRepository;
    }

    @QueryHandler
    public List<BloodbankRestModel> findBloodbank(FindBloodbankQuery query){
        List<BloodbankRestModel> bloodbankRest = new ArrayList<>();
        List<BloodbankEntity> storedBloodbank = bloodbankRepository.findAll();
        for (BloodbankEntity bloodbankEntity : storedBloodbank) {
            BloodbankRestModel bloodbankRestModel = new BloodbankRestModel();
            BeanUtils.copyProperties(bloodbankEntity, bloodbankRestModel);
            bloodbankRest.add(bloodbankRestModel);
        }
        return bloodbankRest;
    }

    @QueryHandler
    public Optional<BloodbankEntity> findBloodbankById(FindBloodbankByIdQuery query){
        Optional<BloodbankEntity> res = bloodbankRepository.findBy_id(query.getId());
        return res;
    }
}
