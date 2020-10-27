package pl.deska.springbootthymeleaf.repo;

import org.springframework.stereotype.Repository;
import pl.deska.springbootthymeleaf.model.Car;

import java.util.List;
@Repository
public interface CarRepository {

    List<Car> findAll();

    boolean addCar(Car car);

    void updateCar(Car car);

    boolean deleteCar(Car car);
}
