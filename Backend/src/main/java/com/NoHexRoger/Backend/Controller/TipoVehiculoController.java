package com.NoHexRoger.Backend.Controller;

import com.NoHexRoger.Backend.Dto.TipoVehiculoRequest;
import com.NoHexRoger.Backend.Entity.TipoVehiculo;
import com.NoHexRoger.Backend.Service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tipo-vehiculo")
public class TipoVehiculoController {
    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @PostMapping
    public ResponseEntity<TipoVehiculo> crearTipoVehiculo(@RequestBody TipoVehiculoRequest tipoVehiculoRequest) {
        return new ResponseEntity<>(tipoVehiculoService.crear(tipoVehiculoRequest), HttpStatus.CREATED);
    }
}
