package com.BookMyShow.Web.Service;

import com.BookMyShow.Web.Dto.UserRequestDto;
import com.BookMyShow.Web.Models.User;
import com.BookMyShow.Web.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto){
        try {
            User user = User.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();
            userRepository.save(user);
            return "create User successfully";
        }catch (Exception e){
            return "problem create User";
        }
    }

    public User findByName(String name){
        User user = userRepository.findByName(name);
        return user;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
