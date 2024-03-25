package com.zep.jobms.jobs;

import java.util.List;

public interface JobsService {

    List<Jobs> findAll();
    void createJobs(Jobs job);

    Jobs getJobsByID(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Jobs updatedJob);
}
