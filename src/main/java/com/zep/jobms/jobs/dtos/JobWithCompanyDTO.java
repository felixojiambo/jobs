package com.zep.jobms.jobs.dtos;

import com.zep.jobms.jobs.Jobs;
import com.zep.jobms.jobs.external.Company;
import lombok.Data;

@Data
public class JobWithCompanyDTO {
    private Jobs jobs;
    private Company company;
}
