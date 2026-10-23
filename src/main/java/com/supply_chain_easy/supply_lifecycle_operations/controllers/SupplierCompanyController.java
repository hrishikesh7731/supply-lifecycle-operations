package com.supply_chain_easy.supply_lifecycle_operations.controllers;

import com.supply_chain_easy.supply_chain_base_operations.models.SupplierCompany;
import com.supply_chain_easy.supply_lifecycle_operations.dtos.requests.SupplierCompanyDto;
import com.supply_chain_easy.supply_lifecycle_operations.services.SupplierCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/slo/company")
public class SupplierCompanyController {

    private final SupplierCompanyService supplierCompanyService;

    @Autowired
    public SupplierCompanyController(SupplierCompanyService supplierCompanyService){
        this.supplierCompanyService=supplierCompanyService;
    }

    @PostMapping("/register")
    public ResponseEntity<SupplierCompany> registerSupplierCompany(@RequestBody SupplierCompanyDto supplierCompanyDto){
        SupplierCompany supplierCompany= supplierCompanyService.registerSupplierCompany(supplierCompanyDto);

        return new ResponseEntity<>(supplierCompany, HttpStatus.CREATED);
    }
}
