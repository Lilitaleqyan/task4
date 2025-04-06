package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().persist(car);

    }

    @Transactional
    @Override
    public List<Car> listCars() {
        TypedQuery<Car> carTypedQuery = sessionFactory.getCurrentSession().createQuery("from Car", Car.class);

        return carTypedQuery.getResultList();
    }
    @Transactional
    @Override
    public User findUserbyCarSerialAndModel(int series, String model) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().
                createQuery("SELECT u FROM User u WHERE u.car.series = :series " +
                            "and u.car.model = :model", User.class);
        query.setParameter("series", series);
        query.setParameter("model", model);
        return query.getResultList().stream().findFirst().orElse(null);
    }
}
