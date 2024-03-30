package com.zep.jobms.jobs.clients;

import com.zep.jobms.jobs.external.Company;
import com.zep.jobms.jobs.external.Reviews;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="REVIEWSMS")
public interface ReviewClient {
    @GetMapping("/crud/reviews")
    List<Reviews> getAllReviews(@RequestParam("companyId") Long companyId);
}
