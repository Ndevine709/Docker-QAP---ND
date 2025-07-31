package com.golfclub.tournaments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.golfclub.members.Members;

@RestController
@CrossOrigin
public class TournamentsController {
    @Autowired
    private TournamentsService tournamentsService;

    // Get all tournaments
    @GetMapping("/tournaments")
    public List<Tournaments> getAllTournaments() {
        return tournamentsService.getAllTournaments();
    }

    // Get a tournament by ID
    @GetMapping("/tournaments/{id}")
    public Tournaments getTournamentsById(@PathVariable Long id) {
        return tournamentsService.getTournamentsById(id);
    }

    // Create a tournament
    @PostMapping("/tournaments")
    public Tournaments createTournament(@RequestBody Tournaments tournament) {
        return tournamentsService.createTournament(tournament);
    }

    // Search for a tournament by start date
    @GetMapping("/tournaments/start-date")
    public List<Tournaments> findTournamentsByStartDate(@RequestParam String startDate) {
        return tournamentsService.findTournamentsByStartDate(startDate);
    }

    // Search for a tournament by location
    @GetMapping("/tournaments/location")
    public List<Tournaments> findTournamentsByLocation(@RequestParam String location) {
        return tournamentsService.findTournamentsByLocation(location);
    }

    // Add a member to a tournament
    @PostMapping("/tournaments/{tournamentId}/{memberId}")
    public Tournaments addMemberToTournament(@PathVariable Long tournamentId, @PathVariable Long memberId) {
        return tournamentsService.addMemberToTournament(tournamentId, memberId);
    }

    // Get all members in a tournament
    @GetMapping("/tournaments/{tournamentId}/members")
    public List<Members> getAllMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentsService.getAllMembersInTournament(tournamentId);
    }
}
