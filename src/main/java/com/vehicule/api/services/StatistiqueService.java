package com.vehicule.api.services;

import com.vehicule.api.entity.Statistique;
import com.vehicule.api.entity.Match;
import com.vehicule.api.entity.TypeStat;
import com.vehicule.api.entity.Player;
import com.vehicule.api.repository.StatistiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class StatistiqueService {
    private final StatistiqueRepository statistiqueRepository;

    @Autowired
    public StatistiqueService(StatistiqueRepository statistiqueRepository) {
        this.statistiqueRepository = statistiqueRepository;
    }

    public Statistique saveStatistique(double nombre,Player player,Match match,TypeStat typeStat){
        Statistique stat = new Statistique();
        stat.setNombre(nombre);
        stat.setPlayer(player);
        stat.setMatch(match);
        stat.setTypeStat(typeStat);
        stat = statistiqueRepository.save(stat);
        return stat;
    }

    public List<Object[]> getStatistiquesJoueurs() {
        return statistiqueRepository.getStatistiquesJoueurs();
    }
    public List<Object[]> getStatistiquesEquipes(String id) {
        return statistiqueRepository.getStatistiquesEquipes(id);
    }
}
