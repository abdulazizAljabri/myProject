package com.example.program.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class InsurancePackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Should be not null")
    private Double insurancePrice;
    private String duration = "Year";
    @NotEmpty(message = "Should be not empty")
    @Column(columnDefinition = "varchar(15) NOT NULL unique check(insuranceType = 'Third party insurance' or insuranceType = 'full insurance')")
    private String insuranceType;
    @ManyToOne
    @JoinColumn(name = "insurance_id" , referencedColumnName = "id")
    @JsonIgnore
    private Insurance insurance;
}
