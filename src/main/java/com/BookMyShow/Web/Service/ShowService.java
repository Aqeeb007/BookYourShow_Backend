package com.BookMyShow.Web.Service;

import com.BookMyShow.Web.Dto.ShowRequestDto;
import com.BookMyShow.Web.Models.*;
import com.BookMyShow.Web.Repository.MovieRepository;
import com.BookMyShow.Web.Repository.ShowRepository;
import com.BookMyShow.Web.Repository.ShowSeatRepository;
import com.BookMyShow.Web.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;




    public String createShow(ShowRequestDto showRequestDto){
        Show show = Show.builder().showDate(showRequestDto.getShowDate()).showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();

        int movieId = showRequestDto.getMovieId();
        int theaterId = showRequestDto.getTheaterId();

        Movie movie = movieRepository.findById(movieId).get();
        show.setMovie(movie);

        Theater theater = theaterRepository.findById(theaterId).get();
        show.setTheater(theater);

       movie.getShows().add(show);
       theater.getShows().add(show);




        List<ShowSeat> showSeatList = createShowSeats(theater.getTheaterSeats());

        show.setShowSeatList(showSeatList);


        for (ShowSeat showSeat : showSeatList){
            showSeat.setShow(show);
        }
        movieRepository.save(movie);
        theaterRepository.save(theater);


        return "added show";

    }

    public List<ShowSeat> createShowSeats(List<TheaterSeat> theaterSeats){
        List<ShowSeat> list = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeats){
            ShowSeat showSeat = ShowSeat.builder().seatType(theaterSeat.getSeatType()).seatNo(theaterSeat.getSeatNo()).build();
        list.add(showSeat);
        }
        showSeatRepository.saveAll(list);
        return list;
    }
}
