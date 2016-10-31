package by.pvt.dumping.service.impl;

import by.pvt.dumping.dao.ICategoryDAO;
import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.entity.Category;
import by.pvt.dumping.service.ICategoryService;
import by.pvt.dumping.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
public class  CategoryService implements ICategoryService {

    private ICategoryDAO dao;

    @Autowired
    public CategoryService(ICategoryDAO dao){
        this.dao = dao;
//        System.out.println("in SERVICE (Category) constructors");
    }

    @Override
    public Category find(int id) throws ServiceException {
        Category category;
        try {
//            beginTransaction();
            category = dao.find(id);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return category;
    }

    @Override
    public List<Category> findAll() throws ServiceException {
        List<Category> categories;
        try {
//            beginTransaction();
            categories = dao.findAll();
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return categories;
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Category category) throws ServiceException {
        try {
//            beginTransaction();
            dao.saveOrUpdate(category);
//            commitTransaction();
        } catch (DaoException e) {
//            rollbackTransaction();
            throw new ServiceException();
        }
        return true;
    }

    @Override
    public int count() throws ServiceException {
        return 0;
    }

}
