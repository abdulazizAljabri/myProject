package com.example.program.Repository;

import com.example.program.Model.InsurancePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsurancePackageRepository extends JpaRepository<InsurancePackage,Integer> {
    InsurancePackage findInsurancePackageById(Integer id);
    List<InsurancePackage> findInsurancePackageByInsurancePriceIsLessThan(Integer insurancePrice);

    List<InsurancePackage>findInsurancePackageByInsuranceType(String insuranceType);


}
