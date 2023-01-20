package com.BookMyShow.Web.Controller;

import com.BookMyShow.Web.Dto.ShowRequestDto;
import com.BookMyShow.Web.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;


    @PostMapping("/create")
    public String createShow(@RequestBody()ShowRequestDto showRequestDto){
        return showService.createShow(showRequestDto);
    }
}
