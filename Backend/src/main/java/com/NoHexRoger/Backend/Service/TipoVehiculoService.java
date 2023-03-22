package com.NoHexRoger.Backend.Service;

import com.NoHexRoger.Backend.Entity.TipoVehiculo;
import com.NoHexRoger.Backend.Repository.TipoVehiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoVehiculoService {
    private TipoVehiculoRepository tipoVehiculoRepository;

    public TipoVehiculo getByName(String tipo) {
        return tipoVehiculoRepository.findByTipo(tipo);
    }
}
