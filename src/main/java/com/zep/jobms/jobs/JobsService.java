package com.zep.jobms.jobs;

import com.zep.jobms.jobs.dtos.JobsDTO;

import java.util.List;

public interface JobsService {

    List<JobsDTO> findAll();
    void createJobs(Jobs job);

    JobsDTO getJobsByID(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Jobs updatedJob);
}
