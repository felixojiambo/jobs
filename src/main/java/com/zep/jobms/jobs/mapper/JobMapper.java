package com.zep.jobms.jobs.mapper;

import com.zep.jobms.jobs.Jobs;
import com.zep.jobms.jobs.dtos.JobsDTO;
import com.zep.jobms.jobs.external.Company;
import com.zep.jobms.jobs.external.Reviews;

import java.util.List;

public class JobMapper {
    public  static JobsDTO mapToJobWithCompanyDto(
            Jobs jobs,
            Company company, List<Reviews> reviews
    ){
        JobsDTO jobsDTO =new JobsDTO();
        jobsDTO.setId(jobs.getId());
        jobsDTO.setTitle(jobs.getTitle());
        jobsDTO.setDescription(jobs.getDescription());
        jobsDTO.setLocation(jobs.getLocation());
        jobsDTO.setMaxSalary(jobs.getMaxSalary());
        jobsDTO.setMinSalary(jobs.getMinSalary());
        jobsDTO.setCompany(company);
        jobsDTO.setReviews(reviews);
        return jobsDTO;
    }
}
