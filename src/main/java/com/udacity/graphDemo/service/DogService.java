package com.udacity.graphDemo.service;

import com.udacity.graphDemo.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Object> retrieveDogBreeds() {}

    public Object retrieveDogBreedsById(Long id) {}

    public List<Object> retrieveDogNames() {}
}
