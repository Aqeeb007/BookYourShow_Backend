package com.BookMyShow.Web.Service;

import com.BookMyShow.Web.Dto.MovieDto;
import com.BookMyShow.Web.Models.Movie;
import com.BookMyShow.Web.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieDto movieDto){
        try {
            Movie movie = Movie.builder().duration(movieDto.getDuration()).name(movieDto.getName()).releaseDate(movieDto.getReleaseDate()).build();
            movieRepository.save(movie);
            return "Movie saved";
        }catch (Exception e){
            return "movie not added";
        }
    }
}
