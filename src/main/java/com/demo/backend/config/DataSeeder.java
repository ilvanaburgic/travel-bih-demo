package com.demo.backend.config;

import com.demo.backend.model.Attraction;
import com.demo.backend.model.Category;
import com.demo.backend.repository.AttractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AttractionRepository attractionRepository;

    public DataSeeder(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @Override
    public void run(String... args) {
        // Always reseed for development
        attractionRepository.deleteAll();
        seedAttractions();
    }

    private void seedAttractions() {
        attractionRepository.save(new Attraction(
                "Stari Most",
                "Mostar",
                Category.HISTORICAL,
                "The iconic 16th-century Ottoman bridge, a UNESCO World Heritage Site. The bridge stands 24 meters above the Neretva River and is a symbol of reconciliation and international cooperation.",
                "https://upload.wikimedia.org/wikipedia/commons/a/a2/Stari_Most22.jpg"
        ));

        attractionRepository.save(new Attraction(
                "Sebilj",
                "Sarajevo",
                Category.HISTORICAL,
                "A wooden fountain in the center of Bascarsija square, the heart of old Sarajevo. Built in Ottoman style, it has become the symbol of Sarajevo and a popular meeting point.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAiAcRRZT-K-0aAlBZN0I18ayTqAZLc8mj6A&s"
        ));

        attractionRepository.save(new Attraction(
                "Most Mehmed Paše Sokolovića",
                "Višegrad",
                Category.HISTORICAL,
                "A UNESCO World Heritage Site, this bridge was built in the 16th century by the famous Ottoman architect Mimar Sinan. It inspired the Nobel Prize-winning novel 'The Bridge on the Drina'.",
                "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh-pkTP_8qXYVOh9DthNmT2J8_xZcCRHTBCieMN2dlilOAEUIu0dtgJkxp-kq3mcbnpHUo1Auz5h2svNKQc7hw6SK-0D6Pwj0uxJoFQUfiObgAy_Y39oXv1DbpOf-hT31cxF1hTIlPNrDE/s1600/mostvisegrad.jpg"
        ));

        attractionRepository.save(new Attraction(
                "Vrelo Bosne",
                "Sarajevo",
                Category.NATURE,
                "The spring of the Bosna River, located at the foothills of Mount Igman. A beautiful park with crystal-clear springs, walking paths, and horse-drawn carriages.",
                "https://media.spottedbylocals.com/spot/vrelo-bosne-sarajevo-by-alan-dardagan.jpg"
        ));

        attractionRepository.save(new Attraction(
                "Skakavac Waterfall",
                "Sarajevo",
                Category.WATERFALL,
                "A stunning 98-meter high waterfall located in the Skakavac Nature Monument near Sarajevo. One of the highest waterfalls in Bosnia and Herzegovina.",
                "https://funkytours.com/wp-content/uploads/2021/01/skakavac-1.jpg"
        ));

        attractionRepository.save(new Attraction(
                "Šarena Džamija i Tvrđava",
                "Travnik",
                Category.HISTORICAL,
                "The colorful mosque (Šarena Džamija) and the medieval fortress of Travnik, the former capital of the Ottoman province of Bosnia. The fortress offers panoramic views of the town.",
                "https://upload.wikimedia.org/wikipedia/commons/5/53/%C5%A0arena_d%C5%BEamija.jpg"
        ));

        System.out.println("Seeded 6 attractions to database.");
    }
}
