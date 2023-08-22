package com.example.program.Repository;

import com.example.program.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    Insurance findInsuranceById(Integer id);

    Insurance findInsuranceByName(String name);
}

