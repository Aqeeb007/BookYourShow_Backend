package com.BookMyShow.Web.Service;

import com.BookMyShow.Web.Dto.TicketResponseDto;
import com.BookMyShow.Web.Dto.UserRequestDto;
import com.BookMyShow.Web.Models.Ticket;
import com.BookMyShow.Web.Models.User;
import com.BookMyShow.Web.Repository.TicketRepository;
import com.BookMyShow.Web.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;



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

    public TicketResponseDto getTicket(Integer ticketId){
        Ticket ticket =ticketRepository.findById(ticketId).get();

        String movie = ticket.getShow().getMovie().getName();
        String theater = ticket.getShow().getTheater().getName();
        String showTime = ticket.getShow().getShowTime().toString();
        String showDate = ticket.getShow().getShowDate().toString();
        String seat = ticket.getAllowedSeat();


        TicketResponseDto ticketResponseDto = TicketResponseDto.builder().showTime(showTime).movieName(movie).theaterName(theater).showDate(showDate).seatNo(seat).build();

        return ticketResponseDto;
    }
}
