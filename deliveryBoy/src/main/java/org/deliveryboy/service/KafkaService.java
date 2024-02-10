package org.deliveryboy.service;

import org.deliveryboy.util.AppConstants;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean updateLocation(String location){
        kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
        return true;
    }

}
