package com.example.the_anarchy_helper.repository;

import com.example.the_anarchy_helper.entity.RewardActionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RewardActionResultRepository extends JpaRepository<RewardActionResult, Integer> {
   // permette di recuperare tutte le reward action che hanno come risoluzione la risorsa desiderata
    List<RewardActionResult> findByResourceId(Integer resourceId);
}
