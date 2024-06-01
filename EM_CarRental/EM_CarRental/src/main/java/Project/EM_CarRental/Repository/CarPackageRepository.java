package Project.EM_CarRental.Repository;

import Project.EM_CarRental.Entities.CarPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarPackageRepository extends JpaRepository<CarPackage, Long> {
    Optional<CarPackage> findByPackageName(String name);
}
