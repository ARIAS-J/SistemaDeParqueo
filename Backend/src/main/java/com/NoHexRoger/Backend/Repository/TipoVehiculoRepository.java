package com.NoHexRoger.Backend.Repository;

import com.NoHexRoger.Backend.Entity.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Long> {
    TipoVehiculo findByTipo(String tipo);
}
