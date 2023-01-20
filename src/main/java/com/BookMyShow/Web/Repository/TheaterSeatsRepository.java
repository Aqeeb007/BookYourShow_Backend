package com.BookMyShow.Web.Repository;

import com.BookMyShow.Web.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeat,Integer> {
}
