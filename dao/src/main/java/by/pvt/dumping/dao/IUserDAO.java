package by.pvt.dumping.dao;

import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.entity.User;


public interface IUserDAO extends IDAO<User> {

    boolean checkAuthentication(String login, String password) throws DaoException;
    User getUserByLogin(String login) throws DaoException;

}
