package pl.deska.springbootthymeleaf.repo;

import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Service;
import pl.deska.springbootthymeleaf.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CarRepositoryImpl implements CarRepository {

    private List<Car> cars;

    public CarRepositoryImpl() {
        Car car1 = new Car(1L, "BMW", "I8");
        Car car2 = new Car(2L, "AUDI", "A6");
        Car car3 = new Car(3L, "TESLA", "S");
        this.cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public boolean addCar(Car car) {
        if (!car.isEmpty()) {
           return cars.add(car);
        }
        throw new IllegalArgumentException("Car cannot be empty");
    }


    @Override
    public void updateCar(Car updatedCar) {
        Car carToDelete = findById(updatedCar.getId());
        cars.remove(carToDelete);
        cars.add(updatedCar);
    }


    @Override
    public boolean deleteCar(Car car) {
        Optional<Car> carToDelete = cars.stream().filter(c -> c.equals(car)).findFirst();
        if (carToDelete.isPresent() && !car.isEmpty()) {
            return cars.remove(carToDelete.get());
        }
        throw new IllegalArgumentException("Car that you want to delete didnt exist");
    }

    public Car findById(Long id) {
        Optional<Car> optionalCar = cars.stream().filter(car -> car.getId() == id).findFirst();
        if (optionalCar.isPresent() && !optionalCar.get().isEmpty()) {
            return optionalCar.get();
        }
        throw new IllegalArgumentException("Car that you want to update didnt exist");
    }


}
