package com.NoHexRoger.Backend.Controller;

import com.NoHexRoger.Backend.Dto.TipoVehiculoRequest;
import com.NoHexRoger.Backend.Entity.TipoVehiculo;
import com.NoHexRoger.Backend.Service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-vehiculo")
public class TipoVehiculoController {
    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TipoVehiculo> getAllTipo(){return tipoVehiculoService.getTipoVehiculos();}

    @PostMapping
    public ResponseEntity<TipoVehiculo> crearTipoVehiculo(@RequestBody TipoVehiculoRequest tipoVehiculoRequest) {
        return new ResponseEntity<>(tipoVehiculoService.crear(tipoVehiculoRequest), HttpStatus.CREATED);
    }
}
