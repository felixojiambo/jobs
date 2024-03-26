package com.zep.jobms.jobs;

import com.zep.jobms.jobs.dtos.JobWithCompanyDTO;

import java.util.List;

public interface JobsService {

    List<JobWithCompanyDTO> findAll();
    void createJobs(Jobs job);

    Jobs getJobsByID(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Jobs updatedJob);
}
