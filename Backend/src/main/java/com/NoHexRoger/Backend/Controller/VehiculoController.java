package com.NoHexRoger.Backend.Controller;

import com.NoHexRoger.Backend.Dto.VehiculoRequest;
import com.NoHexRoger.Backend.Dto.VehiculoResponse;
import com.NoHexRoger.Backend.Entity.Vehiculo;
import com.NoHexRoger.Backend.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAllVehiculos() {
        return new ResponseEntity(vehiculoService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehiculoResponse> createVehiculo(@RequestBody VehiculoRequest vehiculoRequest) {
        return new ResponseEntity(vehiculoService.create(vehiculoRequest), HttpStatus.CREATED);
    }
}
