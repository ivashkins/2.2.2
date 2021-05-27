package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {


    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", required = false) String count, ModelMap map) {
        CarService carService=new CarService();
        map.addAttribute("cars",carService.getCarList(count));
        return "cars";
    }

}
