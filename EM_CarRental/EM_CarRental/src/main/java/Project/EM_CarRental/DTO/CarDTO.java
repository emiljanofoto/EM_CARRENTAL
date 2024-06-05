package Project.EM_CarRental.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Boolean isAvailable;

}
