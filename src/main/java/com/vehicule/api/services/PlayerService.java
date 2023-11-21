package com.vehicule.api.services;

import com.vehicule.api.entity.Team;
import com.vehicule.api.entity.Player;
import com.vehicule.api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player savePlayer(String nom,String numero,Team team){
        Player player = new Player();
        player.setNom(nom);
        player.setNumero(numero);
        player.setTeam(team);
        player = playerRepository.save(player);
        return player;
    }
}
