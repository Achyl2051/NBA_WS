package com.vehicule.api.entity;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "nom_unique",
                columnNames = "nom"
        )
})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String diminutif;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDiminutif() {
        return diminutif;
    }

    public void setDiminutif(String diminutif) {
        this.diminutif = diminutif;
    }
}
