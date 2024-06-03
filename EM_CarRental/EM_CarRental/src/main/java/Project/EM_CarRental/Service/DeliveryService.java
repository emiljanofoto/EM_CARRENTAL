package Project.EM_CarRental.Service;

import Project.EM_CarRental.Entities.Car;
import Project.EM_CarRental.Entities.Order;
import Project.EM_CarRental.Entities.User;
import Project.EM_CarRental.Repository.CarRepository;
import Project.EM_CarRental.Repository.OrderNumberRepository;
import Project.EM_CarRental.Repository.OrderRepository;
import Project.EM_CarRental.Security.UserLogInSecurity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class DeliveryService {

    private static final Long ID = null;
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;
    private final OrderNumberRepository orderNumberRepository;
    private final UserLogInSecurity userLogInSecurity;

    public Car carPickUp(Long carId) {

        Car car = carRepository.findById(carId).orElseThrow(()->new EntityNotFoundException("Car Not Found"));

        User user = userLogInSecurity.getUser();
        if(user.getOrderNumber()==null){
            throw new EntityNotFoundException("Order Nr. Not Found");
        }
        else if(!user.getOrderNumber().getCarPackage().equals(car.getCarPackage().getPackageName())){
            throw new EntityNotFoundException("Invalid Car Package");
        }
        else if(!car.getIsAvailable()){
            throw new EntityNotFoundException("Car is not available");
        }
        else{
            orderNumberRepository.delete(user.getOrderNumber());
            car.setIsAvailable(false);
            LocalDateTime start = LocalDateTime.now();
            LocalDateTime end = LocalDateTime.now()
                    .plusDays(user.getOrderNumber().getDays());

            Order order = new Order(ID , user.getId(), car.getId(), car.getBrand(), car.getModel(), start, end);
            orderRepository.save(order);

        }
        return car;


    }

}
