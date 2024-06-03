package Project.EM_CarRental.Mapper;


import Project.EM_CarRental.DTO.OrderNumberDTO;
import Project.EM_CarRental.Entities.OrderNumber;
import org.springframework.stereotype.Service;

@Service
public class OrderNumberDTOMapper {

    public static OrderNumberDTO mapToOrderNumberDTO(OrderNumber orderNumber) {
        return OrderNumberDTO.builder()
                .id(orderNumber.getId())
                .carPackage(orderNumber.getCarPackage())
                .days(String.valueOf(orderNumber.getDays()))
                .build();
    }


}
