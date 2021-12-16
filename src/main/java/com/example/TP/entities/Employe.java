package com.example.TP.entities;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employe implements Serializable, UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer matricule;
    private String nom;
    private String prenom;
    private Integer téléphone;
    private String email;
    private String username;
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "employes_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "employes_phases",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "phase_id")
    )
    Set<Phase> phases;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projet_id")
    private Project projet;

    public Employe() {
    }

    public Employe(Integer matricule, String nom, String prenom, Integer téléphone, String email, String username, String password, Set<Role> roles, Set<Phase> phases, Project projet) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.téléphone = téléphone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.phases = phases;
        this.projet = projet;
    }

    public Employe(String nom, String prenom,String email, String password, Set<Role> roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTéléphone() {
        return téléphone;
    }

    public void setTéléphone(Integer téléphone) {
        this.téléphone = téléphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Phase> getPhases() {
        return phases;
    }

    public void setPhases(Set<Phase> phases) {
        this.phases = phases;
    }

    public Project getProjet() {
        return projet;
    }

    public void setProjet(Project projet) {
        this.projet = projet;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
