package com.BookMyShow.Web.Controller;

import com.BookMyShow.Web.Dto.TheaterRequestDto;
import com.BookMyShow.Web.Models.Theater;
import com.BookMyShow.Web.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public String addTheater(@RequestBody()TheaterRequestDto theaterRequestDto){
        return theaterService.createTheater(theaterRequestDto);
    }

    @GetMapping("/getTheaters")
    public List<String> findTheaterWithMovie(){
        return theaterService.findTheaters();
    }
}
