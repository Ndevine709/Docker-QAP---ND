package com.golfclub.tournaments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golfclub.members.Members;
import com.golfclub.members.MembersRepository;

@Service
public class TournamentsService {
    @Autowired
    private TournamentsRepository tournamentsRepository;

    @Autowired
    private MembersRepository membersRepository;

    public List<Tournaments> getAllTournaments() {
        return (List<Tournaments>) tournamentsRepository.findAll();
    }

    public Tournaments getTournamentsById(Long id) {
        Optional<Tournaments> optionalTournament = tournamentsRepository.findById(id);
        return optionalTournament.orElse(null);
    }

    public Tournaments createTournament(Tournaments tournament) {
        return tournamentsRepository.save(tournament);
    }

    public List<Tournaments> findTournamentsByStartDate(String startDate) {
        return tournamentsRepository.findByStartDate(startDate);
    }

    public List<Tournaments> findTournamentsByLocation(String location) {
        return tournamentsRepository.findByLocation(location);
    }

    public Tournaments addMemberToTournament(Long tournamentId, Long memberId) {
        Optional<Tournaments> optionalTournament = tournamentsRepository.findById(tournamentId);
        Optional<Members> optionalMembers = membersRepository.findById(memberId);

        if (optionalTournament.isPresent() && optionalMembers.isPresent()) {
            Tournaments tournament = optionalTournament.get();
            Members member = optionalMembers.get();

            Set<Members> members = tournament.getMembers();

            if (members != null) {
                members.add(member);
                tournament.setMembers(members);
                return tournamentsRepository.save(tournament);
            }
        }
        return null;
    }

    public List<Members> getAllMembersInTournament(Long tournamentId) {
        Optional<Tournaments> optionalTournament = tournamentsRepository.findById(tournamentId);
        
        if (optionalTournament.isPresent()) {
            Tournaments tournament = optionalTournament.get();
            Set<Members> membersSet = tournament.getMembers();
            return new ArrayList<>(membersSet);
        } else {
            return new ArrayList<>();
        }
    }
}
