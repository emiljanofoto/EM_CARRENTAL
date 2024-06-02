package Project.EM_CarRental.Entities;

import Project.EM_CarRental.constants.BodyType;
import Project.EM_CarRental.constants.FuelType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "car_category")
public class CarCategory {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_type", nullable = false)
    private BodyType bodyType;

    @Column(name = "number_of_doors", nullable = false)
    private Integer numberOfDoors;

    @JsonIgnore
    @OneToOne(mappedBy = "carCategory")
    private Car car;

}
