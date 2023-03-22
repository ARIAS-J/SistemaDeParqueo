package com.NoHexRoger.Backend.Repository;

import com.NoHexRoger.Backend.Entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
}
