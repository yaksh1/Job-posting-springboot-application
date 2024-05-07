package com.telusko.SpringTry.reviews;

import com.telusko.SpringTry.companies.CompanyModel;
import com.telusko.SpringTry.companies.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final CompanyService companyService;

    public boolean createReview(Long companyId,ReviewModel review) {
        CompanyModel company = companyService.getCompanyById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }
    public List<ReviewModel> getAllReviewsByCompanyId(Long companyId){
        return reviewRepo.findByCompanyId(companyId);
    }

    public boolean deleteById(Long companyId, Long reviewId) {
        List<ReviewModel> reviews = reviewRepo.findByCompanyId(companyId);
        ReviewModel review = reviews.stream()
                .filter(reviewModel -> reviewModel.getReviewId().equals(reviewId))
                .findFirst()
                .orElse(null);
        if(review!=null){
            reviewRepo.deleteById(reviewId);
            return true;
        }
        return false;
    }

    public ReviewModel getReviewByReviewId(Long companyId, Long reviewId) {
        List<ReviewModel> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews.stream()
                .filter(reviewModel -> reviewModel.getReviewId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    public boolean updateReviewById(Long companyId, Long reviewId,ReviewModel updatedReview) {
        List<ReviewModel> reviews = reviewRepo.findByCompanyId(companyId);
        ReviewModel review = reviews.stream()
                .filter(reviewModel -> reviewModel.getReviewId().equals(reviewId))
                .findFirst()
                .orElse(null);
        if(review!=null){
            updatedReview.setReviewId(reviewId);
            updatedReview.setCompany(review.getCompany());
            reviewRepo.save(updatedReview);
            return true;
        }
        return false;
    }
}
