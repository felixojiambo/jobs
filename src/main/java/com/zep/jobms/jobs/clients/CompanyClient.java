package com.zep.jobms.jobs.clients;

import com.zep.jobms.jobs.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="COMPANYMS")
public interface CompanyClient {
 @GetMapping("/crud/company/{id}")
    Company getCompany(Long id);
}
