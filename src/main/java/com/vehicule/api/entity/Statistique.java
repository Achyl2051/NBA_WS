package com.vehicule.api.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Statistique {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private double nombre;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_player",referencedColumnName="id")
    private Player player;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_match",referencedColumnName="id")
    private Match match;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_typestat",referencedColumnName="id")
    private TypeStat typeStat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(double nombre) {
        this.nombre = nombre;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public TypeStat getTypeStat() {
        return typeStat;
    }

    public void setTypeStat(TypeStat typeStat) {
        this.typeStat = typeStat;
    }
}
