package com.supply_chain_easy.supply_lifecycle_operations.controllers;

import com.supply_chain_easy.supply_lifecycle_operations.dtos.requests.SupplierCompanyDto;
import com.supply_chain_easy.supply_lifecycle_operations.services.SupplierCompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/slo/company")
public class SupplierCompanyController {

    @PostMapping("/register")
    public void registerSupplierCompany(@RequestBody SupplierCompanyDto supplierCompanyDto){

    }
}
