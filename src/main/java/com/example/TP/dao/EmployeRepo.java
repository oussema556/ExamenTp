package com.example.TP.dao;


import com.example.TP.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeRepo extends JpaRepository<Employe,Integer> {

    @Query(" select e from Employe e where e.username = ?1")
    Optional<Employe> findUserWithName(String username);

}
