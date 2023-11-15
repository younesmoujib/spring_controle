package com.moujib.controle.services;


import com.moujib.controle.dao.IDao;
import com.moujib.controle.entities.Service;
import com.moujib.controle.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {


    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Service create(Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public Service update(Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public Boolean delete(Service o) {
        try{
           serviceRepository.delete(o);
           return true;

        }catch (Exception e){
            return  false;
        }

    }

    @Override
    public Service findById(Long d) {
        return serviceRepository.findById(d).orElse(null);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
