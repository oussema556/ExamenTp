package com.example.TP;

import com.example.TP.dao.EmployeRepo;
import com.example.TP.dao.RoleRepo;
import com.example.TP.entities.Employe;
import com.example.TP.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TpApplication implements CommandLineRunner {

	@Autowired
	RoleRepo roleRepo;
	@Autowired
	EmployeRepo employeRepo;

	public static void main(String[] args) {
		SpringApplication.run(TpApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{
		Set<Role> Emp1Roles = new HashSet<Role>();
		Set<Role> Emp2Roles = new HashSet<Role>();
		Role adminRole = new Role (1,"ADMIN");
		Role secRole =new Role(2,"SECRETAIRE	");
		roleRepo.save(adminRole);
		roleRepo.save(secRole);
		Emp1Roles.add(secRole);
		Employe emp1 =new Employe("user","user","bejaouioussama556@gmail.com","oussama2000",Emp1Roles);
		Emp2Roles.add(adminRole);
		Employe emp2 = new Employe("admin","admin","bejaoioussama321@gmail.com","oussama2001",Emp2Roles);
		employeRepo.save(emp1);
		employeRepo.save(emp2);
	}
}
