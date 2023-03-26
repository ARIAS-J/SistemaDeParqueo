package com.NoHexRoger.Backend.Controller;

import com.NoHexRoger.Backend.Dto.EstanciaReportItem;
import com.NoHexRoger.Backend.Dto.EstanciaRequest;
import com.NoHexRoger.Backend.Dto.EstanciaResponse;
import com.NoHexRoger.Backend.Dto.FinalizarEstanciaRequest;
import com.NoHexRoger.Backend.Entity.Estancia;

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
    public List<Estancia> getAll() {
        return estanciaService.getEstancias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estancia> getEstanciaById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(estanciaService.getEstanciaById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstanciaResponse> createEstancia(@RequestBody EstanciaRequest estanciaRequest) {
        return new ResponseEntity(estanciaService.createEstancia(estanciaRequest), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estancia> updateEstancia(@PathVariable("id") Integer id, @RequestBody Estancia estanciaRequest) {
        return estanciaService.updateEstancia(id, estanciaRequest);
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Estancia> updateEstancia(@PathVariable("id") Integer id, @RequestBody FinalizarEstanciaRequest finalizarEstanciaRequest) {
        return new ResponseEntity<>(estanciaService.finalizarEstancia(id, finalizarEstanciaRequest), HttpStatus.OK);
    }

    @GetMapping("/deudas")
    public ResponseEntity<List<EstanciaReportItem>> getReporteEstancias() {
        return new ResponseEntity<>(estanciaService.getReporteEstancias(), HttpStatus.OK);
    }
}
