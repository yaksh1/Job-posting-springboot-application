package com.telusko.SpringTry.reviews;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telusko.SpringTry.companies.CompanyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String reviewTitle;
    private String reviewDescription;
    @JsonIgnore
    @ManyToOne
    private CompanyModel company;
}
