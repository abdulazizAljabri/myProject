package com.example.program.Controller;

import com.example.program.Api.ApiResponse;
import com.example.program.Model.Insurance;
import com.example.program.Service.InsuranceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/insurances")
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    @GetMapping("/")
    public ResponseEntity getInsurances() {
        return ResponseEntity.status(HttpStatus.OK).body(insuranceService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addInsurance(@RequestBody @Valid Insurance insurance) {
        insuranceService.addInsurance(insurance);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Insurance added"));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateInsurance(@PathVariable Integer id,@RequestBody @Valid Insurance insurance) {
        insuranceService.updateInsurance(id, insurance);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Insurance updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteInsurance(@PathVariable Integer id) {
        insuranceService.removeInsurance(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Insurance deleted"));
    }
    @GetMapping("/search/{name}")
    public ResponseEntity searchByInsuranceName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(insuranceService.findInsuranceByName(name));
    }
    @GetMapping("/description/{insuranceId}")
    public ResponseEntity addDescription(@PathVariable Integer insuranceId) {
          insuranceService.addDescription(insuranceId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Description added"));
    }
}
