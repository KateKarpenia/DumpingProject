package by.pvt.dumping.service;

import by.pvt.dumping.entity.Product;
import by.pvt.dumping.service.exceptions.ServiceException;

import java.util.List;
import java.util.Map;


public interface IProductService extends IService<Product> {

    List<Product> getProductsByLogin(String login, Map<String, Integer> paginationParams) throws ServiceException;
    int countProductsByLogin(String login) throws ServiceException;
    List<Product> getProductsInCategory(int id, Map<String, Integer> paginationParams) throws ServiceException;
    int countProductsInCategory(int id) throws ServiceException;
    List<Product> getProductsInCategoryByLogin(int id, String login, Map<String, Integer> paginationParams) throws ServiceException;
    int countProductsInCategoryByLogin(int id, String login) throws ServiceException;
    public List<Product> findAll(Map<String, Integer> paginationParams) throws ServiceException;

}
