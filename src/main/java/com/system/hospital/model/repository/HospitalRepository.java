package com.system.hospital.model.repository;

import com.system.hospital.model.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital,Integer>   {
}
