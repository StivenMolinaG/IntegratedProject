package com.IntegratedProjectSpring.IntegratedProjectApplication.repositories;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {
    Turn findTurnById(Integer id);
}
