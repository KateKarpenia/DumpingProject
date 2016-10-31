package by.pvt.dumping.service;

import by.pvt.dumping.service.exceptions.ServiceException;

import java.util.List;


public interface IService<T> {

    T find(int id) throws ServiceException;
    List<T> findAll() throws ServiceException;
    boolean delete(int id) throws ServiceException;
    boolean saveOrUpdate(T t) throws ServiceException;
    int count() throws ServiceException;

}
