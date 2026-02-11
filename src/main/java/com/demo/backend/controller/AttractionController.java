package com.demo.backend.controller;

import com.demo.backend.dto.ErrorResponse;
import com.demo.backend.model.Attraction;
import com.demo.backend.service.AttractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping
    public ResponseEntity<List<Attraction>> getAllAttractions() {
        return ResponseEntity.ok(attractionService.getAllAttractions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttractionById(@PathVariable Long id) {
        return attractionService.getAttractionById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body(new ErrorResponse("Attraction not found")));
    }
}
