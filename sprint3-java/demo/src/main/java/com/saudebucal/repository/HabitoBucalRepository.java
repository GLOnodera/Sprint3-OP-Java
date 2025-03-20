package com.saudebucal.repository;

import com.saudebucal.model.HabitoBucal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitoBucalRepository extends JpaRepository<HabitoBucal, Long> {
    List<HabitoBucal> findByUserId(Long userId);
}