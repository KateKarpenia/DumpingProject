package by.pvt.dumping.service;

import by.pvt.dumping.entity.User;
import by.pvt.dumping.service.exceptions.ServiceException;


public interface IUserService extends IService<User> {

    boolean checkAuthentication(String login, String password) throws ServiceException;
    User find(String login) throws ServiceException;

}
