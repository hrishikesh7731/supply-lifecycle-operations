package com.supply_chain_easy.supply_lifecycle_operations.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierCompanyDto{
    private String supplierCategory;
    private Integer leadTimeDays;
    private BigDecimal minimumOrderValue;
    private String companyName;
    private String legalName;
    private String gstNumber;
    private String email;
    private String website;
    private String contactNumber;
}
