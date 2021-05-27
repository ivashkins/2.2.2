package web.service;

import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class  CarService {
    private static List<Car> carList = new ArrayList<>();

    {
        carList.add(new Car("Bmw", "e36", 24));
        carList.add(new Car("Bmw", "e38", 20));
        carList.add(new Car("Bmw", "e46", 18));
        carList.add(new Car("Bmw", "e60", 11));
        carList.add(new Car("Bmw", "e90", 8));
    }

    public List<Car> getCarList(String  count){
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
        return carList;
    }
}
