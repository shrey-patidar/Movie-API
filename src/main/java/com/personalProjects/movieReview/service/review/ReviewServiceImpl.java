package com.personalProjects.movieReview.service.review;

import com.personalProjects.movieReview.entity.movie.Movie;
import com.personalProjects.movieReview.entity.review.Review;
import com.personalProjects.movieReview.repo.review.ReviewRepo;
import com.personalProjects.movieReview.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepo reviewRepo;

    private MongoTemplate mongoTemplate;

    @Autowired
    public void setReviewRepo(ReviewRepo reviewRepo){
        this.reviewRepo = reviewRepo;
    }

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = new Review();
        review.setBody(reviewBody);
        Review savedReview = reviewRepo.insert(review);

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(savedReview))
                .first();

        return savedReview;
    }
}
