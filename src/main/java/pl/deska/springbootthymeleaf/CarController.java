package pl.deska.springbootthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/car")
    public String hello(Model model){
        Car car1 = new Car("BMW", "I8");
        Car car2 = new Car("AUDI", "A6");
        Car car3 = new Car("TESLA", "S");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        model.addAttribute("cars", cars);
        return "car";
    }

}
