package Project.EM_CarRental.Repository;

import Project.EM_CarRental.Entities.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarCategoryRepository extends JpaRepository<CarCategory, Long>{
}
