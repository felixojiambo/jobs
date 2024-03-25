package com.zep.jobms.jobs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zep.JobApplication.companies.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="jobs_table")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private  String title;
    private  String description;
    private String minSalary;
    private  String maxSalary;
    private  String Location;
    @JsonIgnore
    @ManyToOne
    private Company company;
}
