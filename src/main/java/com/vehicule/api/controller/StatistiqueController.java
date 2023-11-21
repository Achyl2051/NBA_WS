package com.vehicule.api.controller;

import com.vehicule.api.entity.Player;
import com.vehicule.api.entity.Match;
import com.vehicule.api.entity.TypeStat;
import com.vehicule.api.entity.Statistique;
import com.vehicule.api.repository.StatistiqueRepository;
import com.vehicule.api.repository.MatchRepository;
import com.vehicule.api.repository.PlayerRepository;
import com.vehicule.api.repository.TypeStatRepository;
import com.vehicule.api.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StatistiqueController {
    private final StatistiqueService statistiqueService;
    private final StatistiqueRepository statistiqueRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final TypeStatRepository typeStatRepository;

    @Autowired
    public StatistiqueController(StatistiqueService statistiqueService, StatistiqueRepository statistiqueRepository, PlayerRepository playerRepository,MatchRepository matchRepository,TypeStatRepository typeStatRepository){
        this.statistiqueService = statistiqueService;
        this.statistiqueRepository = statistiqueRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.typeStatRepository = typeStatRepository;
    }

    @GetMapping("/statistiques")
    public List<Statistique> findAll(){
        return statistiqueRepository.findAll();
    }

    @PostMapping("/statistique")
    public Statistique saveStatistique(double nombre, Long idPlayer, Long idMatch, Long idTypeStat){
        Player player = playerRepository.findById(idPlayer).get();
        Match match = matchRepository.findById(idMatch).get();
        TypeStat typeStat = typeStatRepository.findById(idTypeStat).get();
        return statistiqueService.saveStatistique(nombre,player,match,typeStat);
    }

    @GetMapping("/statbyjoueurs")
    public List<Object[]> getStatistiquesJoueurs() {
        return statistiqueService.getStatistiquesJoueurs();
    }
    @GetMapping("/statbyequipes/{id}")
    public List<Object[]> getStatistiquesEquipes(@PathVariable String id) {
        return statistiqueService.getStatistiquesEquipes(id);
    }

}
