package com.vehicule.api.services;

import com.vehicule.api.entity.Team;
import com.vehicule.api.entity.Match;
import com.vehicule.api.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match saveMatch(Team team1,Team team2,String date){
        Match match = new Match();
        match.setDate(date);
        match.setTeam1(team1);
        match.setTeam2(team2);
        match = matchRepository.save(match);
        return match;   
    }
}
