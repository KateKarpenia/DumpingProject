package by.pvt.dumping.dao;

import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.entity.Product;

import java.util.List;
import java.util.Map;


public interface IProductDAO extends IDAO<Product>  {

    List<Product> findAll(Map<String, Integer> paginationParams) throws DaoException;
    List<Product> getProductsByLogin(String login, Map<String, Integer> paginationParams) throws DaoException;
    int countProductsByLogin(String login) throws DaoException;
    List<Product> getProductsInCategory(int id, Map<String, Integer> paginationParams) throws DaoException;
    int countProductsInCategory(int id) throws DaoException;
    List<Product> getProductsInCategoryByLogin(int id, String login, Map<String, Integer> paginationParams) throws DaoException;
    int countProductsInCategoryByLogin(int id, String login) throws DaoException;

}
