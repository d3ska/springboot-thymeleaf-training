package pl.deska.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.deska.springbootthymeleaf.model.Car;
import pl.deska.springbootthymeleaf.repo.CarRepository;



@Controller
public class CarController {

    private CarRepository carRepo;

    @Autowired
    public CarController(CarRepository carService) {
        this.carRepo = carService;
    }

    @GetMapping("/home")
    public String hello(Model model) {
        model.addAttribute("cars", carRepo.findAll());
        model.addAttribute("carTemplate", new Car());
        return "home";
    }



    @GetMapping("/to-add")
    public String addCar(Model model) {
           model.addAttribute("carTemplate", new Car());
            return "addCar";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        carRepo.addCar(car);
        return "redirect:/home";
    }



    @GetMapping("/to-update")
    public String updateCar(Model model){
        model.addAttribute("carTemplate", new Car());
        return "updateCar";
    }

    @PostMapping("/update-car")
    public String saveUpdatedCar(@ModelAttribute Car car){
        carRepo.updateCar(car);
        return "redirect:/home";
    }



    @GetMapping("/to-delete")
    public String deleteCar(Model model){
        model.addAttribute("carTemplate", new Car());
        return "deleteCar";
    }

    @PostMapping("/delete-car")
    public String removeCar(@ModelAttribute Car car){
        carRepo.deleteCar(car);
        return "redirect:/home";
    }

}
