package by.pvt.dumping.dao.impl;

import by.pvt.dumping.dao.AbstractDAO;
import by.pvt.dumping.dao.IProductDAO;
import by.pvt.dumping.dao.constants.CriteriaParams;
import by.pvt.dumping.dao.exceptions.DaoException;
import by.pvt.dumping.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class ProductDAOImpl extends AbstractDAO<Product> implements IProductDAO {

    @Autowired
    private ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
//        System.out.println("in DAO (Product) constructors");
    }



    public List<Product> findAll (Map<String, Integer> paginationParams) throws DaoException {
        List<Product> products;

        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
            Criteria productCriteria = session.createCriteria(Product.class);
            productCriteria.setFirstResult( (selected - 1)*quantity );
            productCriteria.setMaxResults( quantity );
            products = (List<Product>) productCriteria.list();

        } catch (HibernateException e) {
            logger.logError(getClass(), "Find all entities error: " + e.getMessage());
            throw new DaoException();
        }
        return products;

    }

    public List<Product> getProductsByLogin(String login, Map<String, Integer> paginationParams) throws DaoException {
        List<Product> products;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
            Criteria productCriteria = session.createCriteria(Product.class);
            Criteria userCriteria = productCriteria.createCriteria("user");
            userCriteria.add(Restrictions.eq("email", login));
            productCriteria.setFirstResult( (selected - 1)*quantity );
            productCriteria.setMaxResults( quantity );
            products = (List<Product>) productCriteria.list();

        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return products;
    }


    public int countProductsByLogin(String login) throws DaoException {
        int count;
        try {
            Session session = currentSession();
            Criteria productCriteria = session.createCriteria(Product.class);
            Criteria userCriteria = productCriteria.createCriteria("user");
            userCriteria.add(Restrictions.eq("email", login));
            productCriteria.setProjection(Projections.rowCount());
            count = (int)(long) productCriteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Entities counting error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }

    public List<Product> getProductsInCategory(int id, Map<String, Integer> paginationParams) throws DaoException {
        List<Product> products;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
            Criteria productCriteria = session.createCriteria(Product.class);
            Criteria categoryCriteria = productCriteria.createCriteria("category");
            categoryCriteria.add(Restrictions.eq("id", id));
            productCriteria.setFirstResult( (selected - 1)*quantity );
            productCriteria.setMaxResults( quantity );
            products = (List<Product>) productCriteria.list();

        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return products;
    }

    public int countProductsInCategory(int id) throws DaoException {
        int count;
        try {
            Session session = currentSession();
            Criteria productCriteria = session.createCriteria(Product.class);
            Criteria categoryCriteria = productCriteria.createCriteria("category");
            categoryCriteria.add(Restrictions.eq("id", id));
            productCriteria.setProjection(Projections.rowCount());
            count = (int)(long) productCriteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Entities counting error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }

    public List<Product> getProductsInCategoryByLogin(int id, String login, Map<String, Integer> paginationParams) throws DaoException {
        List<Product> products;
        try {

            int selected = paginationParams.get(CriteriaParams.SELECTED_PAGE);
            int quantity = paginationParams.get(CriteriaParams.QUANTITY_PER_PAGE);

            Session session = currentSession();
            Criteria productCriteria = session.createCriteria(Product.class);
            Criteria categoryCriteria = productCriteria.createCriteria("category");
            categoryCriteria.add(Restrictions.eq("id", id));
            Criteria userCriteria = productCriteria.createCriteria("user");
            userCriteria.add(Restrictions.eq("email", login));
            productCriteria.setFirstResult( (selected - 1)*quantity );
            productCriteria.setMaxResults( quantity );
            products = (List<Product>) productCriteria.list();
        } catch (HibernateException e) {
            logger.logError(getClass(), e.getMessage());
            throw new DaoException();
        }
        return products;
    }

    public int countProductsInCategoryByLogin(int id, String login) throws DaoException {
        int count;
        try {
            Session session = currentSession();
            Criteria productCriteria = session.createCriteria(Product.class);
            Criteria categoryCriteria = productCriteria.createCriteria("category");
            categoryCriteria.add(Restrictions.eq("id", id));
            Criteria userCriteria = productCriteria.createCriteria("user");
            userCriteria.add(Restrictions.eq("email", login));
            productCriteria.setProjection(Projections.rowCount());
            count = (int)(long) productCriteria.uniqueResult();
        } catch (HibernateException e) {
            logger.logError(getClass(), "Entities counting error: " + e.getMessage());
            throw new DaoException();
        }
        return count;
    }

}
