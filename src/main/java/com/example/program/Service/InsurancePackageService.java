package com.example.program.Service;

import com.example.program.Api.ApiException;
import com.example.program.Model.Insurance;
import com.example.program.Model.InsurancePackage;
import com.example.program.Repository.InsurancePackageRepository;
import com.example.program.Repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsurancePackageService {
    private final InsurancePackageRepository insurancePackageRepository;
    private final InsuranceRepository insuranceRepository;

    public List<InsurancePackage> gatAll(){
        return insurancePackageRepository.findAll();
    }

    public void addService(InsurancePackage insurancePackage){
        insurancePackageRepository.save(insurancePackage);
    }

    public void updateService(Integer id,InsurancePackage insurancePackage){
        InsurancePackage insurancePackage1 = insurancePackageRepository.findInsurancePackageById(id);
        if(insurancePackage1 == null){
            throw new ApiException("Insurance package not found");
        }
        insurancePackage1.setInsurancePrice(insurancePackage.getInsurancePrice());
        insurancePackage1.setInsuranceType(insurancePackage.getInsuranceType());
        insurancePackageRepository.save(insurancePackage1);
    }

    public void removeService(Integer id){
        InsurancePackage insurancePackage1 = insurancePackageRepository.findInsurancePackageById(id);
        if(insurancePackage1 == null){
            throw new ApiException("Insurance package not found");
        }
        insurancePackageRepository.delete(insurancePackage1);
    }
    public void assignServiceToInsurance(Integer insurance_id, Integer service_id){
        Insurance insurance = insuranceRepository.findInsuranceById(insurance_id);
        InsurancePackage insurancePackage1 = insurancePackageRepository.findInsurancePackageById(service_id);
        if(insurancePackage1 == null || insurance == null){
            throw new ApiException("can not ");
        }
        insurancePackage1.setInsurance(insurance);
        insurancePackageRepository.save(insurancePackage1);
    }

    public List<InsurancePackage> searchByInsuranceType(String insuranceType){
        List<InsurancePackage> insurancePackage  = insurancePackageRepository.findInsurancePackageByInsuranceType(insuranceType);
        if(insurancePackage == null){
            throw new ApiException("Insurance package not found");
        }
        return insurancePackage;
    }

    public List<InsurancePackage>searchByInsurancePrice(Integer insurancePrice){
        List<InsurancePackage> insurancePackage = insurancePackageRepository.findInsurancePackageByInsurancePriceIsLessThan(insurancePrice);
        if(insurancePackage == null){
            throw new ApiException("Insurance package not found");
        }
        return insurancePackage;
    }
}
