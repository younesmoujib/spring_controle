package com.moujib.controle.services;

import com.moujib.controle.dao.IDao;
import com.moujib.controle.entities.Employe;
import com.moujib.controle.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeService implements IDao<Employe> {
    @Autowired
    private ServiceService s;


    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe create(Employe o) {
        return employeRepository.save(o);
    }

    @Override
    public Employe update(Employe o) {
        return employeRepository.save(o);
    }

    @Override
    public Boolean delete(Employe o) {
       try{
          employeRepository.delete(o);
          return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public Employe findById(Long d) {
        return employeRepository.findById(d).orElse(null);
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }





}
