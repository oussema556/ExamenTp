package com.example.TP.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String nom;
    private String description;
    private Date datedébut;
    private Date datefin;
    private double montant;
    private boolean etat;//( 0 en cours, 1 cloturé)

    @OneToMany(mappedBy = "phase_projet")
    Set<Phase> phases;

    @OneToOne(mappedBy = "projet")
    private Employe employe;

    public Project() {
    }

    public Project(Long code, String nom, String description, Date datedébut, Date datefin, double montant, boolean etat, Set<Phase> phases, Employe employe) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.datedébut = datedébut;
        this.datefin = datefin;
        this.montant = montant;
        this.etat = etat;
        this.phases = phases;
        this.employe = employe;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedébut() {
        return datedébut;
    }

    public void setDatedébut(Date datedébut) {
        this.datedébut = datedébut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Set<Phase> getPhases() {
        return phases;
    }

    public void setPhases(Set<Phase> phases) {
        this.phases = phases;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
