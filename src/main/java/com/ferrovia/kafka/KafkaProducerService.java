package com.ferrovia.kafka;

import com.ferrovia.model.Emprunt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "emprunts";

    @Autowired
    private KafkaTemplate<String, Emprunt> kafkaTemplate;

    public void sendEmprunt(Emprunt emprunt) {
        kafkaTemplate.send(TOPIC, emprunt);
    }
}
