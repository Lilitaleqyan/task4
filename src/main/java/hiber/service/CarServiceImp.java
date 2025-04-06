package hiber.service;
import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CarServiceImp implements CarService {

  private final CarDao carDao;

  public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Transactional
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Transactional
    @Override
    public User findUserbyCarSerialAndModel(int series, String model) {
        return carDao.findUserbyCarSerialAndModel(series, model);
    }
}
