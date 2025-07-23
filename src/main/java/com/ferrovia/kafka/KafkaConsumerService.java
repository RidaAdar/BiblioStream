package com.ferrovia.kafka;

import com.ferrovia.model.Emprunt;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "emprunts", groupId = "biblio-group")
    public void consume(Emprunt emprunt) {
        System.out.println("Nouvel emprunt reçu via Kafka : " + emprunt);
    }
}
