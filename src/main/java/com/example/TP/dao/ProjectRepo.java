package com.example.TP.dao;

import com.example.TP.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
