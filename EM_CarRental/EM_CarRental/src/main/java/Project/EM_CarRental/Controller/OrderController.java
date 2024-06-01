package Project.EM_CarRental.Controller;


import Project.EM_CarRental.Entities.Order;
import Project.EM_CarRental.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody String carPackage, @RequestParam Integer days) {
        return orderService.addOrder(carPackage, days);
    }



}


