package com.zep.jobms.jobs.mapper;

import com.zep.jobms.jobs.Jobs;
import com.zep.jobms.jobs.dtos.JobWithCompanyDTO;
import com.zep.jobms.jobs.external.Company;

public class JobMapper {
    public  static JobWithCompanyDTO mapToJobWithCompanyDto(
            Jobs jobs,
            Company company
    ){
        JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
        jobWithCompanyDTO.setId(jobs.getId());
        jobWithCompanyDTO.setTitle(jobs.getTitle());
        jobWithCompanyDTO.setDescription(jobs.getDescription());
        jobWithCompanyDTO.setLocation(jobs.getLocation());
        jobWithCompanyDTO.setMaxSalary(jobs.getMaxSalary());
        jobWithCompanyDTO.setMinSalary(jobs.getMinSalary());
        jobWithCompanyDTO.setCompany(company);
        return  jobWithCompanyDTO;
    }
}
