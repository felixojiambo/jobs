package com.zep.jobms.jobs;
import com.zep.jobms.jobs.dtos.JobWithCompanyDTO;
import com.zep.jobms.jobs.external.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobsServiceImpl implements  JobsService{
  private final JobsRepository jobsRepository;

@Autowired
  RestTemplate restTemplate;
    private Long nextId = 1L;

    public JobsServiceImpl(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;

    }

    @Override
    public List<JobWithCompanyDTO> findAll() {
        List<Jobs> jobs=jobsRepository.findAll();
        List<JobWithCompanyDTO> jobWithCompanyDTOs=new ArrayList<>();



       return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }
   private  JobWithCompanyDTO convertToDto(Jobs job){
      // RestTemplate restTemplate=new RestTemplate();
           JobWithCompanyDTO jobWithCompanyDTO=new JobWithCompanyDTO();
           jobWithCompanyDTO.setJobs(job);
           Company company= restTemplate.getForObject("http://localhost:8081/crud/company/" + job.getCompanyId(),
                   Company.class);
           jobWithCompanyDTO.setCompany(company);
         return jobWithCompanyDTO;

   }



    @Override
    public void createJobs(Jobs job) {
        job.setId(nextId++);
        jobsRepository.save(job);
    }

    @Override
    public JobWithCompanyDTO getJobsByID(Long id) {
       Jobs job=jobsRepository.findById(id).orElse(null);
return  convertToDto(job);
    }
    @Override
    public boolean deleteJobById(Long id){
        try {
            jobsRepository.deleteById(id);
            return true;
        }catch (Exception e){ return  false;}

    }

    @Override
    public boolean updateJob(Long id, Jobs updatedJob) {
        Optional<Jobs>jobsOptional=jobsRepository.findById(id);
        {
            if (jobsOptional.isPresent()) {
                Jobs job = jobsOptional.get();
                {
                    job.setTitle(updatedJob.getTitle());
                    job.setDescription(updatedJob.getDescription());
                    job.setMinSalary(updatedJob.getMinSalary());

                    job.setMaxSalary(updatedJob.getMaxSalary());
                    job.setLocation(updatedJob.getLocation());
                    jobsRepository.save(job);
                    return true;
                }
            }
            return false;
        }}
}


