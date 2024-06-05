package Project.EM_CarRental.Service;

import Project.EM_CarRental.DTO.CarDTO;
import Project.EM_CarRental.DTO.CarPackageDTO;
import Project.EM_CarRental.Entities.Car;
import Project.EM_CarRental.Entities.CarCategory;
import Project.EM_CarRental.Entities.CarPackage;
import Project.EM_CarRental.Repository.CarCategoryRepository;
import Project.EM_CarRental.Repository.CarPackageRepository;
import Project.EM_CarRental.Repository.CarRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


import static Project.EM_CarRental.Mapper.CarDTOMapper.mapToCar;
import static Project.EM_CarRental.Mapper.CarPackageDTOMapper.mapToCarPackage;
import static org.springframework.beans.support.PagedListHolder.DEFAULT_PAGE_SIZE;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CarService {
    private final CarRepository carRepository;
    private final CarPackageRepository carPackageRepository;
    private final CarService carService;
    private final CarCategoryRepository carCategoryRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<CarPackage> getCarPackage() {
        return carPackageRepository.findAll();
    }

    public List<Car>getAvailableCars() {
        return carRepository.findAvailableCars(PageRequest.of(0, DEFAULT_PAGE_SIZE));
    }

    public Car getCar(Long id) {
        return carRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("The car with this id does no exist"));
    }

    public Car SaveCar(CarDTO carDTO) {
        Car car = mapToCar(carDTO);
        return carRepository.save(car);

    }

    public Car editCar(Long id, CarDTO carDTO) {
        Car carEdited = carRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Car Not Found"));
        carEdited.setBrand(carDTO.getBrand());
        carEdited.setModel(carDTO.getModel());
        carEdited.setYear(carDTO.getYear());
        carEdited.setColor(carDTO.getColor());
        carEdited.setIsAvailable(carDTO.getIsAvailable());
        return carRepository.save(carEdited);

    }

    public Car setCarCategory(Long id, CarCategory carCategory) {
        Car car = carRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Car Not Found"));
        if(car.getCarCategory() != null){
           carCategoryRepository.delete(car.getCarCategory());
        }
        carCategoryRepository.save(carCategory);
        car.setCarCategory(carCategory);
        return carRepository.save(car);

    }

    public Car setCarPackage(Long id, String packageName) {
        Car car = carRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Car Not Found"));
        CarPackage carPackage = carPackageRepository.findByPackageName(packageName).orElseThrow(()-> new EntityNotFoundException("Car Package Not Found"));
        car.setCarPackage(carPackage);
        return carRepository.save(car);

    }

    public void deleteCar(Long id) {
        if(carRepository.findById(id).isEmpty()){throw new EntityNotFoundException("Car Not Found");}
        carRepository.deleteById(id);
    }

    public CarPackage saveCarPackage(CarPackageDTO carPackageDTO) {
        if(carPackageRepository.findByPackageName(carPackageDTO.getPackageName()).isPresent()) {
            throw new EntityExistsException("Car Package Exists");
        }

        return carPackageRepository.save(mapToCarPackage(carPackageDTO));


    }

    public void deleteCarPackage(Long id) {
        if(carPackageRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException("Car Package Not Found");
        }
        CarPackage carPackage = carPackageRepository.getById(id);
        Collection<Car>cars = carPackage.getCars();
        for(Car car : cars){
            car.setCarPackage(null);
        }
        carPackageRepository.delete(carPackage);
    }

}
