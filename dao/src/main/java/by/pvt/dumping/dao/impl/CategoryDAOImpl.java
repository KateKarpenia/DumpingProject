package by.pvt.dumping.dao.impl;

import by.pvt.dumping.dao.AbstractDAO;
import by.pvt.dumping.dao.ICategoryDAO;
import by.pvt.dumping.entity.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryDAOImpl extends AbstractDAO<Category> implements ICategoryDAO {

    @Autowired
    private CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
//        System.out.println("in DAO (Category) constructors");
    }

//    private static CategoryDAOImpl instance;
//
//    public static synchronized CategoryDAOImpl getInstance(){
//        if(instance == null){
//            instance = new CategoryDAOImpl();
//        }
//        return instance;
//    }

}
