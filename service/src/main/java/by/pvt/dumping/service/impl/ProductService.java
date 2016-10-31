package by.pvt.dumping.service.impl;

import by.pvt.dumping.dao.IProductDAO;
import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.entity.Product;
import by.pvt.dumping.service.IProductService;
import by.pvt.dumping.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
public class ProductService implements IProductService {

    private IProductDAO dao;

    @Autowired
    public ProductService(IProductDAO dao){
        this.dao = dao;
//        System.out.println("in SERVICE (Product) constructors");
    }


    public List<Product> getProductsByLogin(String login, Map<String, Integer> paginationParams) throws ServiceException {
        List<Product> products;
        try {
//            beginTransaction();
            products = dao.getProductsByLogin(login, paginationParams);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return products;
    }

    public int countProductsByLogin(String login) throws ServiceException {
        int count;
        try {
//            beginTransaction();
            count = dao.countProductsByLogin(login);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    public List<Product> getProductsInCategory(int id, Map<String, Integer> paginationParams) throws ServiceException {
        List<Product> products;
        try {
//            beginTransaction();
            products = dao.getProductsInCategory(id, paginationParams);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return products;
    }

    public int countProductsInCategory(int id) throws ServiceException {
        int count;
        try {
//            beginTransaction();
            count = dao.countProductsInCategory(id);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    public List<Product> getProductsInCategoryByLogin(int id, String login, Map<String, Integer> paginationParams) throws ServiceException {
        List<Product> products;
        try {
//            beginTransaction();
            products = dao.getProductsInCategoryByLogin(id, login, paginationParams);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return products;
    }

    public int countProductsInCategoryByLogin(int id, String login) throws ServiceException {
        int count;
        try {
//            beginTransaction();
            count = dao.countProductsInCategoryByLogin(id, login);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    @Override
    public Product find(int id) throws ServiceException {
        Product product;
        try {
//            beginTransaction();
            product = dao.find(id);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return product;
    }

    @Override
    public int count() throws ServiceException {
        int count;
        try {
//            beginTransaction();
            count = dao.count();
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return count;
    }

    @Override
    public List<Product> findAll() throws ServiceException {
        List<Product> products;
        try {
//            beginTransaction();
            products = dao.findAll();
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return products;
    }

    public List<Product> findAll(Map<String, Integer> paginationParams) throws ServiceException {
        List<Product> products;
        try {
//            beginTransaction();
            products = dao.findAll(paginationParams);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        boolean result;
        try {
//            beginTransaction();
            result = dao.delete(id);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return result;
    }

    @Override
    public boolean saveOrUpdate(Product product) throws ServiceException {
        boolean result;
        try {
//            beginTransaction();
            result = dao.saveOrUpdate(product);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return result;
    }

    public IProductDAO getDao() {
        return dao;
    }

    public void setDao(IProductDAO dao) {
        this.dao = dao;
    }


}
