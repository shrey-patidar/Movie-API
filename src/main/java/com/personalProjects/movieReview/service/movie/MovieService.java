package com.personalProjects.movieReview.service.movie;

import com.personalProjects.movieReview.entity.movie.Movie;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface MovieService{
    List<Movie> getAllMovies();

    Optional<Movie> getSingleMovie(String id);
}
