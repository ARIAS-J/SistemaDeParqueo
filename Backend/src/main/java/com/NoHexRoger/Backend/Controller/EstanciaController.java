package com.NoHexRoger.Backend.Controller;

import com.NoHexRoger.Backend.Dto.EstanciaRequest;
import com.NoHexRoger.Backend.Dto.EstanciaResponse;
import com.NoHexRoger.Backend.Entity.Estancia;

import com.NoHexRoger.Backend.Service.EstanciaService;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estancia> getAll(){
        return estanciaService.getEstancias();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Estancia> createEstancia(@RequestBody EstanciaRequest estancia){
        Vehiculo vehiculo = vehiculoService.getVehiculoById(estancia.getVehiculoId()).OrElseThrow();

        Estancia createEstancia = new Estancia();

        createEstancia.setVehiculo(Vehiculo);

        Estancia create = estanciaService.createEstancia(createEstancia);

        EstanciaResponse estanciaResponse = new EstanciaResponse();

        estanciaResponse.setId(create.getId());
        estanciaResponse.setFechaEntrada(create.getFechaEntrada());
        estanciaResponse.setFechaSalida(create.getFechaSalida());
        estanciaResponse.setVehiculoId(create.getVehiculo().getId());

        return ResponseEntity.ok(estanciaResponse);
    }
}
