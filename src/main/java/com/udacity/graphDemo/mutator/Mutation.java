package com.udacity.graphDemo.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.graphDemo.entity.Dog;
import com.udacity.graphDemo.repository.DogRepository;
import com.udacity.graphDemo.service.BreedNotFoundError;
import com.udacity.graphDemo.service.DogNotFoundError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(String breed) {
        Iterable<Dog> dogs = dogRepository.findAll();
        List<Dog> filteredDogsByBreed = StreamSupport.stream(dogs.spliterator(), false)
                .filter((dog) -> dog.getBreed().equals(breed))
                .collect(Collectors.toList());

        if (!filteredDogsByBreed.isEmpty()) {
            filteredDogsByBreed
                    .forEach(dog -> dogRepository.delete(dog));
            return true;
        } else {
            throw new BreedNotFoundError("Breed Not Found: ", breed);
        }
    }

    public Dog updateDogName(Long id, String name) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundError("Dog Not Found With Given Id: ", id);
        }
    }
}
