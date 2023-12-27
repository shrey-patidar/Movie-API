package com.personalProjects.movieReview.service.movie;

import com.personalProjects.movieReview.entity.movie.Movie;
import com.personalProjects.movieReview.repo.movie.MovieRepo;
import com.personalProjects.movieReview.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepo movieRepo;

    @Autowired
    public void setMovieRepo(MovieRepo movieRepo){
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getSingleMovie(String id) {
        return movieRepo.findByImdbId(id);
    }
}
