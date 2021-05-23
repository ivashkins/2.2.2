package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarController {
    private List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("Bmw", "e36", 24));
        carList.add(new Car("Bmw", "e38", 20));
        carList.add(new Car("Bmw", "e46", 18));
        carList.add(new Car("Bmw", "e60", 11));
        carList.add(new Car("Bmw", "e90", 8));
    }

    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count", required = false) String count, ModelMap map) {
        try {
            if (Integer.parseInt(count) > carList.size()) {
                count = String.valueOf(carList.size());
            }
        } catch (Exception e) {
            count = null;
        }
        if (count != null) {
            carList = carList.stream().limit(Integer.parseInt(count)).collect(Collectors.toList());
        }
        map.addAttribute("cars", carList);
        return "cars";
    }

}
