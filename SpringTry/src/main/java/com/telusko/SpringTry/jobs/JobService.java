package com.telusko.SpringTry.jobs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobService {
//    List<JobModel> jobs = new ArrayList<>();
    Long nextId = 1L;
    private final JobRepository jobRepository;
    public List<JobModel> getAllJobs(){
        return jobRepository.findAll();
    }


    public void addJob(@RequestBody JobModel job){
        jobRepository.save(job);
    }

    public JobModel getJobById(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    public boolean deleteJobById(Long id){
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean updateJobById(Long id,JobModel updatedJob) {
        Optional<JobModel> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            JobModel job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setSalary(updatedJob.getSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
