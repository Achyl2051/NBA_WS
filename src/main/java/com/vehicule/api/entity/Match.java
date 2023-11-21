package com.vehicule.api.entity;

import jakarta.persistence.*;
@Entity
@Table
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_team1",referencedColumnName="id")
    private Team team1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_team2",referencedColumnName="id")
    private Team team2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
}
