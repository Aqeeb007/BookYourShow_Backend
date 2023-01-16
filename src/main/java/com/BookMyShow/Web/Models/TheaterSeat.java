package com.BookMyShow.Web.Models;

import com.BookMyShow.Web.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private SeatType seatType;
    private int rate;



    @ManyToOne
    @JoinColumn
    private Theater theater;



}
