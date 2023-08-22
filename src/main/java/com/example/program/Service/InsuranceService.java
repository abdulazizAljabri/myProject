package com.example.program.Service;

import com.example.program.Api.ApiException;
import com.example.program.Model.Insurance;
import com.example.program.Repository.InsurancePackageRepository;
import com.example.program.Repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final InsurancePackageRepository insurancePackageRepository;
    public List<Insurance> getAll(){
        return insuranceRepository.findAll();
    }

    public void addInsurance(Insurance insurance){
        insuranceRepository.save(insurance);
    }

    public void removeInsurance(Integer id){
        Insurance insurances = insuranceRepository.findInsuranceById(id);
        if(insurances == null){
            throw new ApiException("Insurance not found");
        }
        insuranceRepository.delete(insurances);
    }

    public void updateInsurance(Integer id, Insurance insurance){
        Insurance insurances = insuranceRepository.findInsuranceById(id);
        if(insurances == null){
            throw new ApiException("Insurance not found");
        }
        insurances.setInsuranceNumber(insurance.getInsuranceNumber());
        insurances.setName(insurance.getName());
        insurances.setDescription(insurance.getDescription());
        insuranceRepository.save(insurances);
    }

    public Insurance findInsuranceByName(String name){
        Insurance insurance1 = insuranceRepository.findInsuranceByName(name);
        if(insurance1 == null){
            throw new ApiException("Insurance not found");
        }
        return insurance1;
    }

    public void addDescription(Integer insuranceId){
        Insurance insurance1 = insuranceRepository.findInsuranceById(insuranceId);
        if(insurance1 == null){
            throw new ApiException("Insurance not found");
        }
        else if (insurance1.getName().equals("tawuniya")) {
            insurance1.setDescription("hi i am tawuniya");
            insuranceRepository.save(insurance1);
        } else if (insurance1.getName().equals("salama")) {
            insurance1.setDescription("hi i am salama");
            insuranceRepository.save(insurance1);
        }
        else {
            insurance1.setDescription("Walaa Insurance Company provides two types of vehicle insurance, third party insurance, comprehensive insurance. You can get the quote online and insure your car in minutes.");
            insuranceRepository.save(insurance1);
        }
    }
}
