package com.telusko.SpringTry.companies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telusko.SpringTry.jobs.JobModel;
import com.telusko.SpringTry.reviews.ReviewModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String industry;
    private String avgSalary;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<JobModel> jobs;

    @OneToMany(mappedBy = "company")
    private List<ReviewModel> reviews;
}
