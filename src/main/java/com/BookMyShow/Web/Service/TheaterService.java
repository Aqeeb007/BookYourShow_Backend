package com.BookMyShow.Web.Service;

import com.BookMyShow.Web.Dto.TheaterRequestDto;
import com.BookMyShow.Web.Enums.SeatType;
import com.BookMyShow.Web.Models.Show;
import com.BookMyShow.Web.Models.Theater;
import com.BookMyShow.Web.Models.TheaterSeat;
import com.BookMyShow.Web.Repository.ShowRepository;
import com.BookMyShow.Web.Repository.TheaterRepository;
import com.BookMyShow.Web.Repository.TheaterSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {


    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Autowired
    ShowRepository showRepository;



    public String createTheater(TheaterRequestDto theaterRequestDto){
        Theater theater = Theater.builder().name(theaterRequestDto.getName()).city(theaterRequestDto.getCity()).address(theaterRequestDto.getAddress()).build();

        List<TheaterSeat> theaterseats = createTheaterSeats();

        for(TheaterSeat theaterSeat : theaterseats){
            theaterSeat.setTheater(theater);
        }

        theaterRepository.save(theater);
            return "theater Added";
    }

    public List<TheaterSeat> createTheaterSeats(){
       List<TheaterSeat> theaterSeatList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            char ch = (char) ('A'+i);

            String seatNo = "1"+ ch;

            TheaterSeat theaterSeat = new TheaterSeat(seatNo, SeatType.CLASSIC,100);
            theaterSeatList.add(theaterSeat);
        }
        for (int i = 0; i < 5; i++) {
            char ch = (char) ('A'+i);

            String seatNo = "2"+ ch;

            TheaterSeat theaterSeat = new TheaterSeat(seatNo, SeatType.PLATINUM,200);
            theaterSeatList.add(theaterSeat);
        }

        theaterSeatsRepository.saveAll(theaterSeatList);
        return theaterSeatList;
    }

    public List<String> findTheaters(){
        List<String> theaters = new ArrayList<>();
        List<Show> showList =showRepository.findAll();

        for (Show show : showList){
            String theater = show.getTheater().getName();
            if (theaters.contains(theater))
                continue;
            theaters.add(theater);
        }
        return theaters;
    }
}
