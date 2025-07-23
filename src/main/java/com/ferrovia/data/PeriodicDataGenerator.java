package com.ferrovia.data;

import com.ferrovia.model.Livre;
import com.ferrovia.model.Adherent;
import com.ferrovia.model.Emprunt;
import com.ferrovia.repository.LivreRepository;
import com.ferrovia.repository.AdherentRepository;
import com.ferrovia.repository.EmpruntRepository;
import com.ferrovia.kafka.KafkaProducerService;
import com.ferrovia.service.MinioService;
import com.github.javafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class PeriodicDataGenerator {

    @Autowired LivreRepository livreRepo;
    @Autowired AdherentRepository adherentRepo;
    @Autowired EmpruntRepository empruntRepo;
    @Autowired KafkaProducerService kafkaProducerService;
    @Autowired MinioService minioService;

    private final Faker faker = new Faker(new Locale("fr"));
    private final Random rand = new Random();

    @PostConstruct
    public void initData() {
        if (livreRepo.count() == 0) {
            for (int i = 0; i < 10; i++) {
                Livre livre = new Livre();
                livre.setTitre(faker.book().title());
                livre.setAuteur(faker.book().author());
                livre.setIsbn(faker.code().isbn13());
                livreRepo.save(livre);
            }
        }
        if (adherentRepo.count() == 0) {
            for (int i = 0; i < 5; i++) {
                Adherent adherent = new Adherent();
                adherent.setNom(faker.name().fullName());
                adherent.setEmail(faker.internet().emailAddress());
                adherentRepo.save(adherent);
            }
        }
    }

    @Scheduled(fixedRate = 30_000)
    public void generateEmprunt() {
        List<Livre> livres = livreRepo.findAll();
        List<Adherent> adherents = adherentRepo.findAll();
        if (livres.isEmpty() || adherents.isEmpty()) return;

        Livre livre = livres.get(rand.nextInt(livres.size()));
        Adherent adherent = adherents.get(rand.nextInt(adherents.size()));
        Emprunt e = new Emprunt();
        e.setLivre(livre);
        e.setAdherent(adherent);
        e.setDateEmprunt(LocalDate.now());
        empruntRepo.save(e);
        kafkaProducerService.sendEmprunt(e);
        minioService.uploadString("emprunt-" + e.getId() + ".txt", e.toString());
        System.out.println("Emprunt généré, envoyé sur Kafka et MinIO ! " + e);
    }
}
