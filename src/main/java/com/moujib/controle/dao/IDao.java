package com.moujib.controle.dao;

import java.util.List;

public interface IDao <T>{

    T create(T o);
    T update(T o);
    Boolean delete (T o);

    T findById(Long d);

    List<T> findAll();
}
