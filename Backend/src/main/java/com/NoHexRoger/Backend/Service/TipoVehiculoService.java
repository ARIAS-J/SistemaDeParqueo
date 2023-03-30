package com.NoHexRoger.Backend.Service;

import com.NoHexRoger.Backend.Dto.TipoVehiculoRequest;
import com.NoHexRoger.Backend.Entity.TipoVehiculo;
import com.NoHexRoger.Backend.Repository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TipoVehiculoService {

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    public List<TipoVehiculo> getTipoVehiculos (){return tipoVehiculoRepository.findAll();}


    public TipoVehiculo findById(Long id) {
        return tipoVehiculoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public TipoVehiculo crear(TipoVehiculoRequest tipoVehiculoRequest) {
        TipoVehiculo newTipoVehiculo = TipoVehiculo.builder()
                .tipo(tipoVehiculoRequest.getTipo())
                .build();

        return tipoVehiculoRepository.save(newTipoVehiculo);
    }
}
