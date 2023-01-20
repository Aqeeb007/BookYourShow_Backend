package com.BookMyShow.Web.Repository;

import com.BookMyShow.Web.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {

}
