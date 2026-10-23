package com.supply_chain_easy.supply_lifecycle_operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.supply_chain_easy.supply_lifecycle_operations",
		"com.supply_chain_easy.supply_chain_base_operations"
})
public class SupplyLifecycleOperationsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SupplyLifecycleOperationsApplication.class, args);
	}

}
