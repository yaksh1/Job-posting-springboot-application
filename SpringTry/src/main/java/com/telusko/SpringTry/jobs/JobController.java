package com.telusko.SpringTry.jobs;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService service;

    public JobController(JobService service){
        this.service=service;
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<JobModel> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobModel> getJobById(@PathVariable Long id){
        JobModel job =  service.getJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String addJob(@RequestBody JobModel job){
        service.addJob(job);
        return "Job created successfully";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean idDeleted = service.deleteJobById(id);
        if(idDeleted){
            return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody JobModel updatedJob){
        boolean isUpdated = service.updateJobById(id,updatedJob);
        if(isUpdated){
            return  new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
