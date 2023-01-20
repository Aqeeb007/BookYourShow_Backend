package com.BookMyShow.Web.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    private String movieName;
    private String theaterName;
    private String showDate;
    private String showTime;
    private String seatNo;
}
