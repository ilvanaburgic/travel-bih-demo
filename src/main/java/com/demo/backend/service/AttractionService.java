package com.demo.backend.service;

import com.demo.backend.model.Attraction;
import com.demo.backend.repository.AttractionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;

    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> getAllAttractions() {
        return attractionRepository.findAll();
    }

    public Optional<Attraction> getAttractionById(Long id) {
        return attractionRepository.findById(id);
    }
}
