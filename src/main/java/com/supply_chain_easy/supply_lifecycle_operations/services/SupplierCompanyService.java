package com.supply_chain_easy.supply_lifecycle_operations.services;

import com.supply_chain_easy.supply_chain_base_operations.enums.ApplicationCode;
import com.supply_chain_easy.supply_chain_base_operations.models.Employee;
import com.supply_chain_easy.supply_chain_base_operations.models.SupplierCompany;
import com.supply_chain_easy.supply_chain_base_operations.repositories.SupplierCompanyRepository;
import com.supply_chain_easy.supply_chain_base_operations.services.CompanyService;
import com.supply_chain_easy.supply_lifecycle_operations.dtos.requests.SupplierCompanyDto;
import com.supply_chain_easy.supply_lifecycle_operations.transformers.SystemTransformer;
import org.springframework.stereotype.Service;

@Service
public class SupplierCompanyService {

    private final SupplierCompanyRepository supplierCompanyRepository;
    private final CompanyService companyService;
    private final SupplierNotificationService supplierNotificationService;

    public SupplierCompanyService(
            SupplierCompanyRepository supplierCompanyRepository,
            CompanyService companyService,
            SupplierNotificationService supplierNotificationService) {

        this.supplierCompanyRepository = supplierCompanyRepository;
        this.companyService = companyService;
        this.supplierNotificationService = supplierNotificationService;
    }

    public SupplierCompany registerSupplierCompany(SupplierCompanyDto supplierCompanyDto) {

        SupplierCompany supplierCompany =
                SystemTransformer.mapDtoToSupplierCompany(supplierCompanyDto);

        supplierCompany = supplierCompanyRepository.save(supplierCompany);

        Employee admin = companyService.createAdminUserForCompany(
                supplierCompany, ApplicationCode.SLO);

        supplierNotificationService.sendSupplierWelcomeNotification(
                supplierCompany, admin);

        return supplierCompany;
    }
}