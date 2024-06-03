package Project.EM_CarRental.Repository;

import Project.EM_CarRental.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
