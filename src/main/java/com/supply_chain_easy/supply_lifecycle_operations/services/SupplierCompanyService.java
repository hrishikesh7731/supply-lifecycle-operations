package com.supply_chain_easy.supply_lifecycle_operations.services;

import com.supply_chain_easy.supply_chain_base_operations.enums.ApplicationCode;
import com.supply_chain_easy.supply_chain_base_operations.models.Employee;
import com.supply_chain_easy.supply_chain_base_operations.models.SupplierCompany;
import com.supply_chain_easy.supply_chain_base_operations.repositories.SupplierCompanyRepository;
import com.supply_chain_easy.supply_chain_base_operations.services.CompanyService;
import com.supply_chain_easy.supply_lifecycle_operations.dtos.requests.SupplierCompanyDto;
import com.supply_chain_easy.supply_lifecycle_operations.transformers.SystemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierCompanyService {

    private final SupplierCompanyRepository supplierCompanyRepository;
    private final CompanyService companyService;

    @Autowired
    public SupplierCompanyService(SupplierCompanyRepository supplierCompanyRepository,
                                  CompanyService companyService){
        this.supplierCompanyRepository=supplierCompanyRepository;
        this.companyService=companyService;
    }

    public SupplierCompany registerSupplierCompany(SupplierCompanyDto supplierCompanyDto){

        SupplierCompany supplierCompany=SystemTransformer.mapDtoToSupplierCompany(supplierCompanyDto);
        Employee Admin= companyService.createAdminUserForCompany(supplierCompany, ApplicationCode.SLO);

        return supplierCompanyRepository.save(supplierCompany);
    }
}
