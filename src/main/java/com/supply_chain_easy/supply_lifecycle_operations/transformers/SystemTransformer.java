package com.supply_chain_easy.supply_lifecycle_operations.transformers;

import com.supply_chain_easy.supply_chain_base_operations.enums.CompanyStatus;
import com.supply_chain_easy.supply_chain_base_operations.enums.CompanyType;
import com.supply_chain_easy.supply_chain_base_operations.enums.SupplierCategory;
import com.supply_chain_easy.supply_chain_base_operations.models.SupplierCompany;
import com.supply_chain_easy.supply_chain_base_operations.utilites.SystemUtility;
import com.supply_chain_easy.supply_lifecycle_operations.dtos.requests.SupplierCompanyDto;

import java.time.LocalDateTime;

public class SystemTransformer {

    public static SupplierCompany mapDtoToSupplierCompany(SupplierCompanyDto dto) {

        LocalDateTime now = LocalDateTime.now();

        return SupplierCompany.builder()

                // Supplier information
                .supplierCode(SystemUtility.generateId("SUPPLIER"))
                .supplierCategory(SupplierCategory.valueOf(
                        dto.getSupplierCategory().trim().toUpperCase()))
                .leadTimeDays(dto.getLeadTimeDays())
                .minimumOrderValue(dto.getMinimumOrderValue())

                // Company identity
                .companyId(SystemUtility.generateId("COMP"))
                .companyType(CompanyType.valueOf(CompanyType.SUPPLIER_COMPANY.toString()))

                // Company information
                .displayName(dto.getCompanyName())
                .legalName(dto.getLegalName())
                .registrationNumber(dto.getRegistrationNumber())

                // Business information
                .industry(dto.getIndustry())
                .businessDescription(dto.getBusinessDescription())
                .website(dto.getWebsite())

                // Contact information
                .email(dto.getEmail())
                .phoneNumber(dto.getContactNumber())
                .registeredAddress(dto.getRegisteredAddress())

                // Tax information
                .gstNumber(dto.getGstNumber())
                .taxIdentificationNumber(dto.getTaxIdentificationNumber())
                .vatNumber(dto.getVatNumber())

                // Initial state
                .status(CompanyStatus.PENDING_VERIFICATION)
                .active(false)

                // Audit information
                .createdAt(now)
                .updatedAt(now)
                .createdBy("system")
                .updatedBy("system")

                .build();
    }
}
