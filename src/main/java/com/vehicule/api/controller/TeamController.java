package com.vehicule.api.controller;

import com.vehicule.api.entity.Team;
import com.vehicule.api.repository.TeamRepository;
import com.vehicule.api.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {
    private final TeamService teamService;
    private final TeamRepository teamRepository;
    //@Autowired
    public TeamController(TeamService teamService, TeamRepository teamRepository){
        this.teamService = teamService;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    @PostMapping("/team")
    public Team save(String nom,String diminutif){
        return teamService.saveTeam(nom, diminutif);
    }

    @GetMapping("/teams/{id}")
    public Optional<Team> find(@PathVariable("id") Long id){
        return teamRepository.findById(id);
    }

    @PutMapping("/teams/{id}")
    public Team modif(@PathVariable Long id, @RequestBody Team v){
        return teamService.updateTeam(id, v);
    }

    @DeleteMapping("/teams/{id}")
    public void deleteById(@PathVariable Long id){
        teamService.deleteTeam(id);
    }

    @DeleteMapping("/teams")
    public void deleteAll(){
        teamRepository.deleteAll();
    }
}
