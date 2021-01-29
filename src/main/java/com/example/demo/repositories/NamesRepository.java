package com.example.demo.repositories;

import com.example.demo.dal.model.Names;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NamesRepository extends CrudRepository<Names, UUID> {
    Optional<List<Names>> findAllByName(String name);

    void deleteAllByName(String name);
}
