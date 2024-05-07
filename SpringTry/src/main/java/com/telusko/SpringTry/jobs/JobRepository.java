package com.telusko.SpringTry.jobs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobModel,Long> {
}
