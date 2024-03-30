package com.zep.jobms.jobs.dtos;

import com.zep.jobms.jobs.external.Company;
import com.zep.jobms.jobs.external.Reviews;
import lombok.Data;

import java.util.List;

@Data
public class JobsDTO {
    private  Long Id;
    private  String title;
    private  String description;
    private String minSalary;
    private  String maxSalary;
    private  String location;
    private Company company;
    private List<Reviews> reviews;
}
