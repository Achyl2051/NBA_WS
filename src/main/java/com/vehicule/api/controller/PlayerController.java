package com.vehicule.api.controller;

import com.vehicule.api.entity.Player;
import com.vehicule.api.entity.Team;
import com.vehicule.api.repository.TeamRepository;
import com.vehicule.api.repository.PlayerRepository;
import com.vehicule.api.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerService = playerService;
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/players")
    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    @PostMapping("/player")
    public Player savePlayer(String nom, String numero, Long idTeam){
        Team team = teamRepository.findById(idTeam).get();
        return playerService.savePlayer(nom,numero,team);
    }
    

}
