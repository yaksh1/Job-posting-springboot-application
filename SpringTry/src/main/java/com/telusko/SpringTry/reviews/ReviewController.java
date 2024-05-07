package com.telusko.SpringTry.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody ReviewModel review){
        boolean isAdded = reviewService.createReview(companyId,review);
        if(isAdded){
            return new ResponseEntity<>("Review added",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Company Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewModel> getAllReviewsByCompanyId(@PathVariable Long companyId){
        return reviewService.getAllReviewsByCompanyId(companyId);
    }

    @GetMapping("/reviews/{reviewId}")
    @ResponseStatus(HttpStatus.OK)
    public ReviewModel getAllReviewsByReviewId(@PathVariable Long companyId,@PathVariable Long reviewId){
        return reviewService.getReviewByReviewId(companyId,reviewId);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteById(companyId,reviewId);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);

    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody ReviewModel updatedReview){
        boolean isUpdated = reviewService.updateReviewById(companyId,reviewId,updatedReview);
        if(isUpdated){
            return new ResponseEntity<>("Review Updated",HttpStatus.OK);
        }
        return new ResponseEntity<>("Update Failed",HttpStatus.NOT_FOUND);
    }

}
