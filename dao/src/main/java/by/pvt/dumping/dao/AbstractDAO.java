package by.pvt.dumping.dao;

import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.utils.LoggingUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDAO<T> implements IDAO<T> {

    protected LoggingUtil logger = LoggingUtil.INSTANCE;

    protected SessionFactory sessionFactory;

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    @Override
    public T find(int id) throws DaoException {
        T entity;
        try {
            entity = (T) currentSession().get(getPersistentClass(), id);
        } catch (HibernateException e) {
            logger.logError(getClass(), "Find entity error: " + e.getMessage());
            throw new DaoException();
        }
        return entity;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() throws DaoException {
        List<T> entityList;
        try {
            entityList = (List<T>) currentSession().createCriteria(getPersistentClass()).list();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Find all entities error: " + e.getMessage());
            throw new DaoException();
        }
        return entityList;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        T entity;
        try {
            entity = (T) currentSession().load(getPersistentClass(), id);
            currentSession().delete(entity);
        } catch (HibernateException e) {
            logger.logError(getClass(), "Delete entity error: " + e.getMessage());
            throw new DaoException();
        }
        return true;
    }
    @Override
    public boolean saveOrUpdate(T t) throws DaoException {
        try {
            currentSession().saveOrUpdate(t);
        } catch (HibernateException e) {
            logger.logError(getClass(), "Save or update entity error: " + e.getMessage());
            throw new DaoException();
        }
        return true;
    }

    @Override
    public int count() throws DaoException {
        int count;
        try {
            count = (int)(long) currentSession()
                    .createCriteria(getPersistentClass())
                    .setProjection(Projections.rowCount())
                    .uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Entities counting error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
}
