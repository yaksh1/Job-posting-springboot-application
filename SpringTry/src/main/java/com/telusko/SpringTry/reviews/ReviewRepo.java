package com.telusko.SpringTry.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<ReviewModel,Long> {
    List<ReviewModel> findByCompanyId(Long companyId);
}
