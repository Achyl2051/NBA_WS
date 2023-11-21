package com.vehicule.api.controller;

import com.vehicule.api.entity.Match;
import com.vehicule.api.entity.Team;
import com.vehicule.api.repository.TeamRepository;
import com.vehicule.api.repository.MatchRepository;
import com.vehicule.api.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class MatchController {
    private final MatchService matchService;
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public MatchController(MatchService matchService, MatchRepository matchRepository, TeamRepository teamRepository){
        this.matchService = matchService;
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/matchs")
    public List<Match> findAll(){
        return matchRepository.findAll();
    }

    @PostMapping("/match")
    public Match saveMatch(Long idTeam1,Long idTeam2,String date){
        Team team1 = teamRepository.findById(idTeam1).get();
        Team team2 = teamRepository.findById(idTeam2).get();
        return matchService.saveMatch(team1,team2,date);
    }

}
