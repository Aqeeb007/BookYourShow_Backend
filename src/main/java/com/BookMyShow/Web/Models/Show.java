package com.BookMyShow.Web.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table(name = "showInTheater")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;
    private LocalTime showTime;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private int multiplier;


    @ManyToOne
    @JoinColumn
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> tickets;


}
