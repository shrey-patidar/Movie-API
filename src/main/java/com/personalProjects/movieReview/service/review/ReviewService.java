package com.personalProjects.movieReview.service.review;

import com.personalProjects.movieReview.entity.review.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {

    Review createReview(String reviewBody, String imdbId);
}
