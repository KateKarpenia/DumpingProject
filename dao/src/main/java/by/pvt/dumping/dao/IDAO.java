package by.pvt.dumping.dao;

import by.pvt.dumping.dao.exceptions.DaoException;

import java.util.List;


public interface IDAO<T> {

    T find(int id) throws DaoException;
    List<T> findAll() throws DaoException;
    boolean delete(int id) throws DaoException;
    boolean saveOrUpdate(T t) throws DaoException;
    int count() throws DaoException;

}
