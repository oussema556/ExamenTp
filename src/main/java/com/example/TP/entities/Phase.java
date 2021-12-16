package com.example.TP.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phase_id")
    private Long code;
    private String libellé;
    private String description;
    private Date datedébut;
    private Date datefin;
    private double montant ;
    private boolean etat_r; //(1:terminée ou 0:non)
    private boolean etat_f; //(1:facturée ou 0:non)
    private boolean etat_p;// (1:payé ou 0:non).

    //un ensemble d'employés chargés de la réaliser,
    @ManyToOne
    @JoinColumn(name = "projet_id")
    Project phase_projet;

    public Phase() {
    }

    public Phase(Long code, String libellé, String description, Date datedébut, Date datefin, double montant, boolean etat_r, boolean etat_f, boolean etat_p, Project phase_projet) {
        this.code = code;
        this.libellé = libellé;
        this.description = description;
        this.datedébut = datedébut;
        this.datefin = datefin;
        this.montant = montant;
        this.etat_r = etat_r;
        this.etat_f = etat_f;
        this.etat_p = etat_p;
        this.phase_projet = phase_projet;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLibellé() {
        return libellé;
    }

    public void setLibellé(String libellé) {
        this.libellé = libellé;
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

    public boolean isEtat_r() {
        return etat_r;
    }

    public void setEtat_r(boolean etat_r) {
        this.etat_r = etat_r;
    }

    public boolean isEtat_f() {
        return etat_f;
    }

    public void setEtat_f(boolean etat_f) {
        this.etat_f = etat_f;
    }

    public boolean isEtat_p() {
        return etat_p;
    }

    public void setEtat_p(boolean etat_p) {
        this.etat_p = etat_p;
    }

    public Project getPhase_projet() {
        return phase_projet;
    }

    public void setPhase_projet(Project phase_projet) {
        this.phase_projet = phase_projet;
    }
}
