package Project.EM_CarRental.Service;


import Project.EM_CarRental.Entities.Order;
import Project.EM_CarRental.Repository.CarPackageRepository;
import Project.EM_CarRental.Repository.OrderRepository;
import Project.EM_CarRental.Security.UserSecurity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final Long ID = null;
    private final CarPackageRepository carPackageRepository;
    private final OrderRepository orderRepository;
    private final LoggedInUser loggedInUser;


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    public Order addOrder(String carPackage,Integer days) {
        return (Order) orderRepository.findAll();
    }


}
