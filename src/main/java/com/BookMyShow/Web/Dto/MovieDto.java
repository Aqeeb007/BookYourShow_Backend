package com.BookMyShow.Web.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {
    private String name;
    private int duration;
    private Date releaseDate;



}
