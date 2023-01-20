package com.BookMyShow.Web.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private String allowedSeat;
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<ShowSeat> showList;

    @ManyToOne
    @JoinColumn
    private Show show;



}
