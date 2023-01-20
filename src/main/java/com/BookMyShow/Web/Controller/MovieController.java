package com.BookMyShow.Web.Controller;

import com.BookMyShow.Web.Dto.MovieDto;
import com.BookMyShow.Web.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public  String addMovie(@RequestBody()MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }
}
