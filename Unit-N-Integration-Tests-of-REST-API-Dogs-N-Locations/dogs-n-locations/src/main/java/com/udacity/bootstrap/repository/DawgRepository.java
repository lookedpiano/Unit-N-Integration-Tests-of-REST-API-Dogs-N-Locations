package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dawg;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DawgRepository extends CrudRepository<Dawg, Long> {

    @Query("select d.id, d.name from Dawg d")
    List<String> findAllNames();

    @Query("select d.name from Dawg d")
    List<String> findOnlyNames();

    @Query("select d.breed from Dawg d")
    List<String> findOnlyBreedsDistinct();

    @Query("select d.id, d.breed from Dawg d where d.id=:id")
    String findBreedById(Long id);
}
