package Project.EM_CarRental.Repository;

import Project.EM_CarRental.Entities.OrderNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderNumberRepository extends JpaRepository<OrderNumber, Long> {
}
