package com.example.program.Controller;


import com.example.program.Api.ApiResponse;
import com.example.program.Model.InsurancePackage;
import com.example.program.Service.InsurancePackageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class InsurancePackageController {
    private final InsurancePackageService insurancePackageService;

    @GetMapping("/")
    public List<InsurancePackage> getInsurancePackages() {
        return insurancePackageService.gatAll();
    }

    @PostMapping("/add")
    public ResponseEntity addService(@RequestBody @Valid InsurancePackage service) {
        insurancePackageService.addService(service);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Service added"));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateService(@PathVariable Integer id, @RequestBody @Valid InsurancePackage service) {
        insurancePackageService.updateService(id, service);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Service updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteService(@PathVariable Integer id) {
        insurancePackageService.removeService(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Service deleted"));
    }

    @GetMapping("/assing/{insuranceId}/{serviceId}")
    public ResponseEntity assingService(@PathVariable Integer insuranceId, @PathVariable Integer serviceId) {
        insurancePackageService.assignServiceToInsurance(insuranceId, serviceId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Service Assigned To Insurance"));
    }

    @GetMapping("/type/{insuranceType}")
    public ResponseEntity searchInsurance(@PathVariable String insuranceType) {
        return ResponseEntity.status(HttpStatus.OK).body(insurancePackageService.searchByInsuranceType(insuranceType));
    }

    @GetMapping("/price/{insurancePrice}")
    public ResponseEntity searchInsuranceByPrice(@PathVariable Double insurancePrice) {
        return ResponseEntity.status(HttpStatus.OK).body(insurancePackageService.searchByInsurancePrice(insurancePrice));
    }

    @GetMapping("/discount/{insuranceId}")
    public ResponseEntity searchDiscount(@PathVariable Integer insuranceId){
        insurancePackageService.discountForInsurance(insuranceId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Service discount."));
    }


}

