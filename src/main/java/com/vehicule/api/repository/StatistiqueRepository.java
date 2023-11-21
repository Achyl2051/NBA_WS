package com.vehicule.api.repository;

import com.vehicule.api.entity.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StatistiqueRepository extends JpaRepository<Statistique, Long> {

    @Query("SELECT " +
            "p.nom AS joueur, " +
            "t.diminutif AS equipe, " +
            "COUNT(DISTINCT m.id) AS M, " +
            "SUM(CASE WHEN ts.code = 'MJ' THEN s.nombre ELSE 0 END) AS MJ, " +
            "SUM(CASE WHEN ts.code = 'P' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS PPM, " +
            "SUM(CASE WHEN ts.code = 'RB' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS RPM, " +
            "SUM(CASE WHEN ts.code = 'PD' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS PDPM, " +
            "SUM(CASE WHEN ts.code = 'LF' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS LFPM, " +
            "SUM(CASE WHEN ts.code = '3P' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS TPPM, " +
            "SUM(CASE WHEN ts.code = '2P' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS DPPM, " +
            "SUM(CASE WHEN ts.code IN ('3P', '2P', 'LF') THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS EFF " +
            "FROM Statistique s " +
            "JOIN Match m ON s.match.id = m.id " +
            "JOIN Player p ON s.player.id = p.id " +
            "JOIN TypeStat ts ON s.typeStat.id = ts.id " +
            "JOIN Team t ON p.team.id = t.id " +
            "GROUP BY p.nom, t.diminutif")
    List<Object[]> getStatistiquesJoueurs();

    @Query("SELECT " +
            "p.nom AS joueur, " +
            "t.diminutif AS equipe, " +
            "COUNT(DISTINCT m.id) AS M, " +
            "SUM(CASE WHEN ts.code = 'MJ' THEN s.nombre ELSE 0 END) AS MJ, " +
            "SUM(CASE WHEN ts.code = 'P' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS PPM, " +
            "SUM(CASE WHEN ts.code = 'RB' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS RPM, " +
            "SUM(CASE WHEN ts.code = 'PD' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS PDPM, " +
            "SUM(CASE WHEN ts.code = 'LF' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS LFPM, " +
            "SUM(CASE WHEN ts.code = '3P' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS TPPM, " +
            "SUM(CASE WHEN ts.code = '2P' THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS DPPM, " +
            "SUM(CASE WHEN ts.code IN ('3P', '2P', 'LF') THEN s.nombre ELSE 0 END) / COUNT(DISTINCT m.id) AS EFF " +
            "FROM Statistique s " +
            "JOIN Match m ON s.match.id = m.id " +
            "JOIN Player p ON s.player.id = p.id " +
            "JOIN TypeStat ts ON s.typeStat.id = ts.id " +
            "JOIN Team t ON p.team.id = t.id " +
            "WHERE t.id = :id " +
            "GROUP BY p.nom, t.diminutif")
    List<Object[]> getStatistiquesEquipes(String id);
}
