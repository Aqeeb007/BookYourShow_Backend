package com.BookMyShow.Web.Controller;

import com.BookMyShow.Web.Dto.UserRequestDto;
import com.BookMyShow.Web.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired

    UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody()UserRequestDto userRequestDto){

        return userService.createUser(userRequestDto);

    }

}
