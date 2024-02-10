package org.deliveryboy.controller;

import org.deliveryboy.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Random;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final KafkaService kafkaService;

    public LocationController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        Random random = new Random();

        for(int i=0;i<1000_000;i++){
            String location = StringTemplate.STR."\{i}. Dhaka \{random.nextInt(1000)}";
            kafkaService.updateLocation(location);
        }

        return ResponseEntity.ok(Collections.singletonMap("message","location updated successfully!"));
    }
}
