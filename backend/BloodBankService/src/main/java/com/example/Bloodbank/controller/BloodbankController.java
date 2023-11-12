package com.example.Bloodbank.controller;

import com.example.Bloodbank.pojo.Bloodbank;
import com.example.Bloodbank.repository.BloodbankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BloodbankController {
    private final BloodbankService bloodbankService;

    @Autowired
    public BloodbankController(BloodbankService bloodbankService) {
        this.bloodbankService = bloodbankService;
    }

    @RequestMapping(value ="/bloodbanks", method = RequestMethod.GET)
    public ResponseEntity<?> getBloodbanks() {
        List<Bloodbank> bloodbanks = bloodbankService.retrieveBloodbanks();
        return ResponseEntity.ok(bloodbanks);
        //ResponseEntity return Object and status 200 OK
    }

    @RequestMapping(value ="/bloodbanks/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBloodbankById(@PathVariable("id") String id) {
        Bloodbank bloodbank = bloodbankService.retrieveBloodbankByID(id);
        return ResponseEntity.ok(bloodbank);
    }

    @RequestMapping(value ="/addBloodbank/{name}/{amount}", method = RequestMethod.POST)
    public ResponseEntity<?> createBloodbank(
            @PathVariable String name,
            @PathVariable int amount) {
        Bloodbank bloodbank = bloodbankService.createBloodbank(new Bloodbank(name, amount));
        return ResponseEntity.ok(bloodbank);
    }

    @RequestMapping(value ="/updateBloodbank/{id}/{nameNew}/{amount}", method = RequestMethod.POST)
    public ResponseEntity<?> updateBloodbank(
            @PathVariable String id,
            @PathVariable String nameNew,
            @PathVariable int amount) {
        Bloodbank bloodbank = bloodbankService.retrieveBloodbankByID(id);
        if(bloodbank != null) {
            Bloodbank bloodbankUpdate = bloodbankService.updateBloodbank(new Bloodbank(id, nameNew, amount));
            return ResponseEntity.ok(bloodbankUpdate);
        } else {
            return ResponseEntity.ok(null);
        }
    }

    @RequestMapping(value ="/deleteBloodbank/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBloodbank(@PathVariable String id) {
        Bloodbank bloodbank = bloodbankService.retrieveBloodbankByID(id);
        return ResponseEntity.ok(bloodbankService.deleteBloodbank(bloodbank));
    }
}
