package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dawg;

import java.util.List;

public interface DawgService {

    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveOnlyDogNames();
    List<String> retrieveDogNames();
    List<Dawg> retrieveDawgs();

}
