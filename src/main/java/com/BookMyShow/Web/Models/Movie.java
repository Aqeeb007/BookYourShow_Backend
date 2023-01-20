package com.BookMyShow.Web.Models;

//import jak.persistence.*;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int duration;
    @Column(nullable = false,unique = true)
    private String name;
    private Date releaseDate;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> shows;


}
