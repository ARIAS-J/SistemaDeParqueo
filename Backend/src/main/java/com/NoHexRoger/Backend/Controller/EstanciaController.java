package com.NoHexRoger.Backend.Controller;

import com.NoHexRoger.Backend.Dto.EstanciaRequest;
import com.NoHexRoger.Backend.Dto.EstanciaResponse;
import com.NoHexRoger.Backend.Entity.Estancia;

import com.NoHexRoger.Backend.Entity.Vehiculo;
import com.NoHexRoger.Backend.Service.EstanciaService;
import com.NoHexRoger.Backend.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estancias")
public class EstanciaController {
    @Autowired
    private EstanciaService estanciaService;

    @Autowired
    private VehiculoService vehiculoService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estancia> getAll(){
        return estanciaService.getEstancias();
    }

    @PostMapping
    public ResponseEntity<Estancia> createEstancia(@RequestBody EstanciaRequest estanciaRequest){
        Vehiculo vehiculo = vehiculoService.getVehiculoById(estanciaRequest.getVehiculoId());

        Estancia newEstancia = Estancia.builder()
                .vehiculo(vehiculo)
                .build();

        estanciaService.createEstancia(newEstancia);

        EstanciaResponse estanciaResponse = EstanciaResponse.builder()
                .vehiculoId(newEstancia.getVehiculo().getPlaca())
                .fechaEntrada(newEstancia.getFechaEntrada())
                .fechaSalida(newEstancia.getFechaSalida())
                .build();

        return new ResponseEntity(newEstancia, HttpStatus.CREATED);
    }
}