package com.zep.jobms.jobs;

import com.zep.jobms.jobs.dtos.JobsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/crud")
public class JobsController {
    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }
//    @Autowired
//    private ServiceDiscoveryTester serviceDiscoveryTester;
//
//    @GetMapping("/service/{serviceName}")
//    public String getServiceUrl(@PathVariable String serviceName) {
//        return serviceDiscoveryTester.getServiceUrl(serviceName);
//    }
    @GetMapping("/jobs")
    public ResponseEntity<List<JobsDTO>> findAll() {

        return ResponseEntity.ok(jobsService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJobs(@RequestBody Jobs job) {
        jobsService.createJobs(job);

        return  new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobsDTO> getJobsByID(@PathVariable Long id) {


        JobsDTO jobsDTO = jobsService.getJobsByID(id);
        if (jobsDTO != null)
            return new ResponseEntity<>(jobsDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/jobs/{id}")
    public  ResponseEntity<String>deleteJob(@PathVariable Long id){
        boolean deleted=jobsService.deleteJobById(id);
        if(deleted)
            return  new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    //we can use request mapping at method levelin every request in the above instead of using specialised methods
    //@RequestMapping9(value="/jobs/{id},method=RequestMethod.PUT)
public  ResponseEntity<String>updateJob(@PathVariable Long id ,@RequestBody Jobs updatedJob){
        boolean updated=jobsService.updateJob(id,updatedJob);
        if(updated)
            return new  ResponseEntity<>("Job updated successfully",HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}