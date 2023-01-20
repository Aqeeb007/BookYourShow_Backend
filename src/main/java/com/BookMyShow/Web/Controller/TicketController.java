package com.BookMyShow.Web.Controller;

import com.BookMyShow.Web.Dto.TicketRequestDto;
import com.BookMyShow.Web.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody()TicketRequestDto ticketRequestDto){
        return ticketService.bookTicket(ticketRequestDto);
    }
    @DeleteMapping("/cancelTicket")
    public String cancelTicket(@RequestParam() Integer ticketId){
        //try {
            ticketService.cancelTicket(ticketId);
            return "cancel ticket";

    }

}
