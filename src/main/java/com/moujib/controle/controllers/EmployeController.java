package com.moujib.controle.controllers;


import com.moujib.controle.entities.Employe;
import com.moujib.controle.entities.Service;
import com.moujib.controle.repository.EmployeRepository;
import com.moujib.controle.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employes")
public class EmployeController {


    @Autowired
    private EmployeService employeService;
    @Autowired
    private EmployeRepository employeRepository;


    @GetMapping("")
    public List<Employe> getALlSErvice(){

        return  employeRepository.findAll();
    }


    @PostMapping("")
    public Employe createEmploye(Employe employe){

        return employeService.create(employe);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmlpyeeByid(@PathVariable Long id){

        Employe employe =employeService.findById(id);

        if(employe == null){

            return new ResponseEntity<Object>("employee not found ", HttpStatus.BAD_REQUEST);
        }else{

            return  ResponseEntity.ok(employe);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmlpyee(@PathVariable Long id){

        Employe employe =employeService.findById(id);
        if(employe == null){
            return new ResponseEntity<Object>("employee not found ", HttpStatus.BAD_REQUEST);
        }else{
            employeService.delete(employe);
            return  ResponseEntity.ok("the employee has been deleted");
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> UpdateEmlpyee(@PathVariable Long id,@RequestBody Employe newEmploye){

        Employe employe =employeService.findById(id);
        if(employe == null){
            return new ResponseEntity<Object>("employee not found ", HttpStatus.BAD_REQUEST);
        }else{
            employe.setId(id);
            employe.setNom(newEmploye.getNom());
            employe.setDateNaissance(newEmploye.getDateNaissance());
            employe.setPrenom(newEmploye.getPrenom());

             employeService.update(employe);
            return  ResponseEntity.ok("the employee has been updated");
        }

    }





}
