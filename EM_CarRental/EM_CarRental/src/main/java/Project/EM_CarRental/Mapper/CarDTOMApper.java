package Project.EM_CarRental.Mapper;


import Project.EM_CarRental.DTO.CarDTO;
import Project.EM_CarRental.Entities.Car;
import org.springframework.stereotype.Service;

@Service
public class CarDTOMApper {

    public static Car mapToCar(CarDTO carDTO) {

        return Car.builder()
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .year(carDTO.getYear())
                .color(carDTO.getColor())
                .isAvailable(carDTO.isAvailable())
                .build();
    }
}

