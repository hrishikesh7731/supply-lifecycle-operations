package com.supply_chain_easy.supply_lifecycle_operations.transformers;

import com.supply_chain_easy.supply_chain_base_operations.enums.CompanyStatus;
import com.supply_chain_easy.supply_chain_base_operations.enums.SupplierCategory;
import com.supply_chain_easy.supply_chain_base_operations.models.SupplierCompany;
import com.supply_chain_easy.supply_chain_base_operations.utilites.SystemUtility;
import com.supply_chain_easy.supply_lifecycle_operations.dtos.requests.SupplierCompanyDto;

import java.time.LocalDateTime;

public class SystemTransformer {

    public static SupplierCompany mapDtoToSupplierCompany(
            SupplierCompanyDto supplierCompanyDto) {

        LocalDateTime now = LocalDateTime.now();

        return SupplierCompany.builder()

                // Supplier information
                .supplierCode(SystemUtility.generateId("SUPPLIER"))
                .supplierCategory(SupplierCategory.valueOf(
                        supplierCompanyDto.getSupplierCategory().toUpperCase()))
                .leadTimeDays(supplierCompanyDto.getLeadTimeDays())
                .minimumOrderValue(supplierCompanyDto.getMinimumOrderValue())

                // Company information
                .companyCode(SystemUtility.generateId("COMP"))
                .displayName(supplierCompanyDto.getCompanyName())
                .legalName(supplierCompanyDto.getLegalName())
                .gstNumber(supplierCompanyDto.getGstNumber())
                .email(supplierCompanyDto.getEmail())
                .website(supplierCompanyDto.getWebsite())
                .phoneNumber(supplierCompanyDto.getContactNumber())
                .status(CompanyStatus.PENDING_VERIFICATION)

                // Audit information
                .createdAt(now)
                .updatedAt(now)
                .createdBy("system")
                .updatedBy("system")

                .build();
    }
}
