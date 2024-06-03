package Project.EM_CarRental.Controller;


import Project.EM_CarRental.Entities.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryController deliveryController;

    @PostMapping("/order_confirmation")
    public Car carPickUp(@RequestBody Long carId) {
        return deliveryController.carPickUp(carId);
    }
    
}
