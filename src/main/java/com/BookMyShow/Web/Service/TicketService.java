package com.BookMyShow.Web.Service;

import com.BookMyShow.Web.Dto.TicketRequestDto;
import com.BookMyShow.Web.Models.*;
import com.BookMyShow.Web.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;



    public String bookTicket(TicketRequestDto ticketRequestDto){
        List<String> requestSeats = ticketRequestDto.getSeats();

        Show show = showRepository.findById(ticketRequestDto.getShowId()).get();
        User user =userRepository.findById(ticketRequestDto.getUserId()).get();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        List<ShowSeat> bookingSeat = new ArrayList<>();

        for (ShowSeat showSeat : showSeatList){
            if(showSeat.isBooked() == false && requestSeats.contains(showSeat.getSeatNo())){
                bookingSeat.add(showSeat);
            }
        }

        if(bookingSeat.size() != requestSeats.size()){
            return "your List Of Ticket Not available";
        }

        Ticket ticket = new Ticket();

        int totalAmount = 0;
        String allowedSeat = "";

        int MP = show.getMultiplier();
        int rate =0;

        for (ShowSeat seat : bookingSeat){
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicket(ticket);
            seat.setShow(show);

            String seatNo = seat.getSeatNo();
            allowedSeat += seatNo + " ";

            if(seatNo.charAt(0) == '1'){
                rate = 100;
            }else{
                rate = 200;
            }
                totalAmount += MP*rate;
        }

        ticket.setBookedAt(new Date());
        ticket.setShow(show);
        ticket.setAllowedSeat(allowedSeat);
        ticket.setAmount(totalAmount);
        ticket.setUser(user);
        ticket.setShowList(bookingSeat);

        ticketRepository.save(ticket);
        return "Ticket Gendered";
    }

    public void cancelTicket(Integer ticketId){
        Ticket ticket = ticketRepository.findById(ticketId).get();

        Show show = ticket.getShow();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for (ShowSeat showSeat : showSeatList){

            if (showSeat.isBooked() == true && showSeat.getTicket().getId() == ticketId){
                showSeat.setBooked(false);
                showSeat.setTicket(null);
                showSeat.setBookedAt(null);
            }
        }
        ticketRepository.deleteById(ticketId);
    }
}
