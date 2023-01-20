package com.BookMyShow.Web.Controller;

import com.BookMyShow.Web.Dto.ShowRequestDto;
import com.BookMyShow.Web.Models.Show;
import com.BookMyShow.Web.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;


    @PostMapping("/create")
    public String createShow(@RequestBody()ShowRequestDto showRequestDto){
        return showService.createShow(showRequestDto);
    }
//    @GetMapping("/shows")
//    public List<Show> findShows(@RequestParam()LocalDate start, @RequestParam() LocalDate end){
//        return showService.findShow(start, end);
//    }
}
