package com.example.demo.DAO;

import com.example.demo.DBO.Masters;

import javax.ejb.Local;

//import javax.ejb.Local;

@Local
public interface IDao<T, PK> {
    T findById(Integer id);
}
