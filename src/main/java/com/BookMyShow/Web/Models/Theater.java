package com.BookMyShow.Web.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String address;


    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> shows;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeats;





}
