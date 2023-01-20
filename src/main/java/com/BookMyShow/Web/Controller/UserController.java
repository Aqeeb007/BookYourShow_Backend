package com.BookMyShow.Web.Controller;

import com.BookMyShow.Web.Dto.TicketResponseDto;
import com.BookMyShow.Web.Dto.UserRequestDto;
import com.BookMyShow.Web.Models.User;
import com.BookMyShow.Web.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired

    UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody()UserRequestDto userRequestDto){

        return userService.createUser(userRequestDto);

    }

   @GetMapping("/user")
    public User findByName(@RequestParam String name){
            return userService.findByName(name);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        return userService.getUsers();
    }

    @GetMapping("/getTicket")
    public TicketResponseDto ticketSend(@RequestParam() Integer ticketId){
        return userService.getTicket(ticketId);
    }

}
