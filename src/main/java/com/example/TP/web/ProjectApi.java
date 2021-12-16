package com.example.TP.web;

import com.example.TP.dao.ProjectRepo;
import com.example.TP.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectApi {

    @Autowired
    ProjectRepo projectRepo;


    @RequestMapping(value="/project",method = RequestMethod.GET)
    @GetMapping
    public List<Project> getProjects(){
        return projectRepo.findAll();
    }

    @RequestMapping(value="/project/{id}",method = RequestMethod.GET)
    public Project getProject(@PathVariable Integer id) {
        return projectRepo.findById(id).get();
    }

    @PostMapping("/project")
    public Project AddProject(@RequestBody Project p){
        return projectRepo.save(p);
    }

    @RequestMapping(value="/project/{idP}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProject(@PathVariable Integer idP) {
        projectRepo.deleteById(idP);
    }


    @RequestMapping(value="/project/{idP}",method = RequestMethod.PUT)
    public Project EditProject(@PathVariable Integer idP, @RequestBody Project project){
        return projectRepo.save(project);
    }

}
