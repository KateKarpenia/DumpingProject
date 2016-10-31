package by.pvt.dumping.dao.impl;

import by.pvt.dumping.dao.AbstractDAO;
import by.pvt.dumping.dao.IUserDAO;
import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.entity.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl extends AbstractDAO<User> implements IUserDAO {

    @Autowired
    private UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
//        System.out.println("in DAO (User) constructors");
    }

    public boolean checkAuthentication(String login, String password) throws DaoException {
        boolean result;
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", login));
            criteria.add(Restrictions.eq("password", password));
            result = !criteria.list().isEmpty();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return result;
    }
    public User getUserByLogin(String login) throws DaoException {
        User user;
        try {
            Session session = currentSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", login));
            user = (User) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return user;
    }


}
