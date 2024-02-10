package org.enduser.config;

import org.enduser.util.AppConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    @KafkaListener(topics = AppConstant.LOCATION_UPDATE_TOPIC,groupId = AppConstant.GROUP_ID)
    public void updateLocation(String location){
        System.out.println("Delivery boy is at :"+location);
    }
}
