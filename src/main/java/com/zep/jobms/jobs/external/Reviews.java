package com.zep.jobms.jobs.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
    private  Long id;
    private String title;
    private  String description;
    private  double rating;

}
