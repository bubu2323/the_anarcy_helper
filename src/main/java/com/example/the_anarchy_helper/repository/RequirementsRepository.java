package com.example.the_anarchy_helper.repository;

import com.example.the_anarchy_helper.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementsRepository extends JpaRepository<Requirement, Integer> {
    List<Requirement> findByRequirement_Id(Integer resourceId);

    List<Requirement> findByRequirement_IdIn(List<Integer> resourceIds);
}
