package com.zep.jobms.jobs.dtos;

import com.zep.jobms.jobs.Jobs;
import com.zep.jobms.jobs.external.Company;
import lombok.Data;

@Data
public class JobWithCompanyDTO {
    private  Long Id;
    private  String title;
    private  String description;
    private String minSalary;
    private  String maxSalary;
    private  String location;
    private Company company;
}
