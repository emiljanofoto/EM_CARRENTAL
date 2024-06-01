package Project.EM_CarRental.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private Long id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isAvailable;

}
