package com.IntegratedProjectSpring.IntegratedProjectApplication.repositories;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
