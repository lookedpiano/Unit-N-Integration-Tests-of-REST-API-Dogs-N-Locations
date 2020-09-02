package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dawg;
import com.udacity.bootstrap.entity.Location;
import com.udacity.bootstrap.repository.DawgRepository;
import com.udacity.bootstrap.repository.LocationRepository;
import com.udacity.bootstrap.service.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DawgServiceImpl implements DawgService {

    @Autowired
    DawgRepository dawgRepository;

    @Override
    public List<Dawg> retrieveDawgs() {
        return (List<Dawg>) dawgRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return (List<String>) dawgRepository.findOnlyBreedsDistinct();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        // without error handling
        // return (String) dawgRepository.findBreedById(id);
        Optional<String> optionalBreed = Optional.ofNullable(dawgRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;

    }

    @Override
    public List<String> retrieveOnlyDogNames() {
        return (List<String>) dawgRepository.findOnlyNames();
    }

    @Override
    public List<String> retrieveDogNames() {
        return (List<String>) dawgRepository.findAllNames();
    }

}
