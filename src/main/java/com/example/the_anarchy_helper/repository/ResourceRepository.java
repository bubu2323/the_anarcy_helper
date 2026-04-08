package com.example.the_anarchy_helper.repository;

import com.example.the_anarchy_helper.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    List<Resource> findByNameIn(List<String> names);
    Optional<Resource> findByName(String name);
}
