package ec.edu.ups.icc.proyecto01.vehiculo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.proyecto01.vehiculo.entity.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findByModel(String model);
    Optional<VehicleEntity> findByBrand(String brand);
    
}
