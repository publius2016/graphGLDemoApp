package com.udacity.graphDemo.web;

import com.udacity.graphDemo.service.DogService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/breeds")
    public @ResponseBody
    ResponseEntity getBreeds() {
        try {
            return new ResponseEntity<>(dogService.retrieveDogBreeds(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Dog Breeds Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/breeds/{id}")
    public @ResponseBody ResponseEntity getBreedsById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(dogService.retrieveDogBreedsById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Dog Breed Not Found With Given Id", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/names")
    public @ResponseBody ResponseEntity getNames() {
        try {
            return new ResponseEntity<>(dogService.retrieveDogNames(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Dog Names Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }
}