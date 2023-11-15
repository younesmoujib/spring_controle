package com.moujib.controle.repository;

import com.moujib.controle.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {

}
