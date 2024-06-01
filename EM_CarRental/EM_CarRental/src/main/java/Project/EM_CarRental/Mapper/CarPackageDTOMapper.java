package Project.EM_CarRental.Mapper;


import Project.EM_CarRental.DTO.CarPackageDTO;
import Project.EM_CarRental.Entities.CarPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarPackageDTOMapper {
    public static CarPackage mapToCarPackage(CarPackageDTO carPackageDTO) {
        return CarPackage.builder()
                .packageName(carPackageDTO.getPackageName())
                .pricePerDay(carPackageDTO.getPricePerDay())
                .cars(new ArrayList<>())
                .build();



    }

}
