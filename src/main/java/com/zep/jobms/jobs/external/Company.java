package com.zep.jobms.jobs.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {

    private  Long id;
    private  String name;
    private  String description;

}