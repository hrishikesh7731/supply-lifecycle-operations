package com.supply_chain_easy.supply_lifecycle_operations.services;

import com.supply_chain_easy.supply_chain_base_operations.models.SupplierCompany;
import com.supply_chain_easy.supply_lifecycle_operations.dtos.requests.SupplierCompanyDto;
import com.supply_chain_easy.supply_lifecycle_operations.transformers.SystemTransformer;

public class SupplierCompanyService {

    public void registerSupplierCompany(SupplierCompanyDto supplierCompanyDto){
         SupplierCompany supplierCompany=SystemTransformer.mapDtoToSupplierCompany(supplierCompanyDto);
    }
}
