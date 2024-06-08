package Project.EM_CarRental.Controller;


import Project.EM_CarRental.DTO.CarDTO;
import Project.EM_CarRental.DTO.CarPackageDTO;
import Project.EM_CarRental.Entities.Car;
import Project.EM_CarRental.Entities.CarCategory;
import Project.EM_CarRental.Entities.CarPackage;
import Project.EM_CarRental.Service.CarService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {

    private  CarService carService;

    @GetMapping("/cars")
    public List<Car> getAllCars(@RequestParam(required = false) Sort.Direction sort) {
        return carService.getAllCars();
    }

    @GetMapping("/car/available")
    public List<Car> getAvailableCars(@RequestParam(required = false) Sort.Direction sort) {
        return carService.getAvailableCars();

    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCar(id);

    }

    @PostMapping("/cars")
    public Car saveCar(@RequestBody CarDTO carDTO) {
        return carService.SaveCar(carDTO);

    }

    @PutMapping("/cars/{id}")
    public Car editCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        return carService.editCar(id, carDTO);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PutMapping("/cars/{id}/category")
    public Car setCarCategory(@PathVariable Long id, @RequestBody CarCategory carCategory) {
        return carService.setCarCategory(id, carCategory);

    }

    @GetMapping("/cars/packages")
    public List<CarPackage> getCarsPackage() {
        return carService.getCarPackage();

    }

    @PutMapping("/cars/{id}/packages")
    public Car setCarPackage(@PathVariable Long id, @RequestParam String packageName) {
        return carService.setCarPackage(id, packageName);
    }

    @PostMapping("/cars/packages")
    public CarPackage saveCarPackage(CarPackageDTO carPackageDTO) {
        return carService.saveCarPackage(carPackageDTO);
    }

    @DeleteMapping("/cars/packages/{id}")
    public void deleteCarPackage(@PathVariable Long id) {
        carService.deleteCarPackage(id);
    }
}
