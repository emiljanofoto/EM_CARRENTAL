package Project.EM_CarRental.Entities;

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
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="brand", nullable=false)
    private String brand;

    @Column(name="model", nullable=false)
    private String model;

    @Column(name="year", nullable=false)
    private int year;

    @Column(name="color", nullable=false)
    private String color;

    @Column(name="is_available", nullable=false)
    private Boolean isAvailable;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "car_package_id", referencedColumnName = "id")
    private CarPackage carPackage;

    @OneToOne(orphanRemoval = true)
    private CarCategory carCategory;




}

