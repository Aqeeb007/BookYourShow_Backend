package com.BookMyShow.Web.Dto;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class ShowRequestDto {
    private LocalDate showDate;
    private LocalTime showTime;
    private int movieId;
    private int theaterId;
    private int multiplier;

}
