package by.pvt.dumping.service.impl;

import by.pvt.dumping.dao.IUserDAO;
import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.entity.User;
import by.pvt.dumping.service.IUserService;
import by.pvt.dumping.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = DaoException.class)
public class UserService implements IUserService {

    private IUserDAO dao;

    @Autowired
    public UserService(IUserDAO dao){
        this.dao = dao;
//        System.out.println("in SERVICE (User) constructors");
    }

    public boolean checkAuthentication(String login, String password) throws ServiceException {
        boolean result;
        try {

            result = dao.checkAuthentication(login, password);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return result;
    }
    public User find(String login) throws ServiceException {
        User user;
        try {

            user = dao.getUserByLogin(login);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return user;
    }

    @Override
    public User find(int id) throws ServiceException {
        User user;
        try {

            user = dao.find(id);

        } catch (DaoException e) {

            throw new ServiceException();
        }
        return user;
    }


    @Override
    public List findAll() throws ServiceException {
        return null;
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        return false;
    }

    @Override
    public boolean saveOrUpdate(User user) throws ServiceException {
        try {
//            beginTransaction();
            dao.saveOrUpdate(user);
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