package com.example.TP.web;


import com.example.TP.dao.EmployeRepo;
import com.example.TP.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeApi {
    @Autowired
    EmployeRepo employeRepo;

    @RequestMapping(value="/employe",method = RequestMethod.GET)
    @GetMapping
    public List<Employe> getEmploye(){
        return employeRepo.findAll();
    }

    @RequestMapping(value="/employe/{id}",method = RequestMethod.GET)
    public Employe getEmploye(@PathVariable Integer id) {
        return employeRepo.findById(id).get();
    }

    @PostMapping("/employe")
    public Employe AddEmploye(@RequestBody Employe e){
        return employeRepo.save(e);
    }

    @RequestMapping(value="/employe/{idemploye}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteEmploye(@PathVariable Integer idemploye) {
        employeRepo.deleteById(idemploye);
    }


    @RequestMapping(value="/employe/{idemploye}",method = RequestMethod.PUT)
    public Employe EditEmploye(@PathVariable Integer idemploye, @RequestBody Employe employe){
        return employeRepo.save(employe);
    }

}
