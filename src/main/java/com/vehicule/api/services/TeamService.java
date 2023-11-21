package com.vehicule.api.services;

import com.vehicule.api.entity.Team;
import com.vehicule.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team saveTeam(String nom, String diminutif){
        Team team = new Team();
        team.setNom(nom);
        team.setDiminutif(diminutif);
        team = teamRepository.save(team);
        return team;
    }

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }

    public Team updateTeam(Long id, Team v){
        v.setId(id);
        teamRepository.save(v);
        return v;
    }
}
