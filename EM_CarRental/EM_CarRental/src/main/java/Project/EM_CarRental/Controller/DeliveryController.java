package Project.EM_CarRental.Controller;


import Project.EM_CarRental.Entities.Car;
import Project.EM_CarRental.Service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/delivery")
    public Car carPickUp(@RequestBody Long carId) {
        return deliveryService.carPickUp(carId);
    }
    
}
