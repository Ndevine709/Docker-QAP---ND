package com.golfclub.tournaments;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TournamentsRepository extends CrudRepository<Tournaments, Long> {
    List<Tournaments> findByStartDate(String startDate);
    List<Tournaments> findByLocation(String location);
}
