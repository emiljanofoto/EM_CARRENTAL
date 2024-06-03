package Project.EM_CarRental.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class OrderNumberDTO {

    private Long id;
    private String carPackage;
    private String days;

}
