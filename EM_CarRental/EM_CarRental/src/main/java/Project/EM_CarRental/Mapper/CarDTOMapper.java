package Project.EM_CarRental.Mapper;


import Project.EM_CarRental.DTO.CarDTO;
import Project.EM_CarRental.Entities.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarDTOMapper {

    public static Car mapToCar(CarDTO carDTO) {

        return Car.builder()
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .year(carDTO.getYear())
                .color(carDTO.getColor())
                .isAvailable(carDTO.getIsAvailable())
                .build();
    }
}

