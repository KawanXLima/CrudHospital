package com.system.hospital.model.repository;

import com.system.hospital.model.entity.Enfermeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Integer> {
    @Override
    Optional<Enfermeiro> findById(Integer id);
}

