package com.zep.jobms.jobs;
import com.zep.jobms.jobs.clients.CompanyClient;
import com.zep.jobms.jobs.clients.ReviewClient;
import com.zep.jobms.jobs.dtos.JobsDTO;
import com.zep.jobms.jobs.external.Company;
import com.zep.jobms.jobs.external.Reviews;
import com.zep.jobms.jobs.mapper.JobMapper;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobsServiceImpl implements  JobsService{
  private final JobsRepository jobsRepository;
  private final CompanyClient companyClient;
  private  final  ReviewClient reviewClient;
@Autowired
  RestTemplate restTemplate;
    private Long nextId = 1L;

    int attempt=0;

    public JobsServiceImpl(JobsRepository jobsRepository, CompanyClient companyClient, ReviewClient reviewClient) {
        this.jobsRepository = jobsRepository;
this.companyClient=companyClient;
this.reviewClient=reviewClient;
    }

    @Override
    //@GetMapping("/jobs")
//@CircuitBreaker(name="companyBreaker",fallbackMethod = "companyBreakerFallback")
    @Retry(name="companyBreaker")
    public List<JobsDTO> findAll() {
        System.out.println("Attempt: "+ ++attempt);
        List<Jobs> jobs=jobsRepository.findAll();
        List<JobsDTO> jobsDTOS =new ArrayList<>();
       return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<String> companyBreakerFallback(Exception e){
        List<String> list=new ArrayList<>();
        list.add("Test");
        return list;
    }
   private JobsDTO convertToDto(Jobs jobs){
      // RestTemplate restTemplate=new RestTemplate();
          // JobsDTO jobsDTO=new JobsDTO();
          // jobsDTO.setJobs(jobs);

//           Company company= restTemplate.getForObject("http://localhost:8081/crud/company/" + jobs.getCompanyId(),
//                   Company.class);
       Company company=companyClient.getCompany(jobs.getCompanyId());
//
//          ResponseEntity<List<Reviews>> reviewsResponse= restTemplate.exchange("http://REVIEWSMS:8083/reviews?companyId=" + jobs.getCompanyId(),
//                   HttpMethod.GET,
//                   null,
//                   new ParameterizedTypeReference<List<Reviews>>() {
//                   }
//           );
       //  List<Reviews>reviews=reviewsResponse.getBody();
       List<Reviews> reviews=reviewClient.getAllReviews(jobs.getCompanyId());

           JobsDTO jobsDTO = JobMapper.mapToJobWithCompanyDto(
             jobs,company,reviews
           );
      // jobsDTO.setCompany(company);
         return jobsDTO;

   }

    @Override
    public void createJobs(Jobs job) {
        job.setId(nextId++);
        jobsRepository.save(job);
    }

    @Override
    public JobsDTO getJobsByID(Long id) {
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


