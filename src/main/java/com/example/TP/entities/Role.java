package com.example.TP.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "roles")
    @JsonIgnore
    private Set<Employe> employes =new HashSet<>();


    public Role() {
    }
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role(Integer id, String name, Set<Employe> users) {
        this.id = id;
        this.name = name;
        this.employes = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(Set<Employe> employes) {
        this.employes = employes;
    }
}
