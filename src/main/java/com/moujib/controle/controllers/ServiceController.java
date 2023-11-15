package com.moujib.controle.controllers;



import com.moujib.controle.entities.Service;
import com.moujib.controle.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService service;



    @GetMapping("")
    public List<Service> getALlSErvice(){

        return service.findAll();
    }

    @PostMapping("")
    public  Service CreateService(Service service1){
        return service.create(service1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getServiceByid(@PathVariable Long id){

      Service s=service.findById(id);

        if(s == null){

            return new ResponseEntity<Object>("service not found ", HttpStatus.BAD_REQUEST);
        }else{

            return  ResponseEntity.ok(s);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteService(@PathVariable Long id){

        Service s=service.findById(id);

        if(s == null){

            return new ResponseEntity<Object>("service not found ", HttpStatus.BAD_REQUEST);
        }else{


            service.delete(s);
            return  ResponseEntity.ok("the service deleted");
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateService(@PathVariable Long id,@RequestBody Service service1){

        Service s=service.findById(id);

        if(s == null){

            return new ResponseEntity<Object>("service not found ", HttpStatus.BAD_REQUEST);
        }else{
            s.setId(id);
            s.setNom(service1.getNom());


            service.update(s);
            return  ResponseEntity.ok("the service updated");
        }

    }





}
