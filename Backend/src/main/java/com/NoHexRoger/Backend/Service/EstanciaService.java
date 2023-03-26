package com.NoHexRoger.Backend.Service;

import com.NoHexRoger.Backend.Entity.Estancia;
import com.NoHexRoger.Backend.Repository.EstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstanciaService {
    @Autowired
    EstanciaRepository estanciaRepository;

    public List<Estancia> getEstancias(){
        return estanciaRepository.findAll();
    }

    public Estancia getEstanciaById(Integer id){
        return estanciaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Estancia createEstancia(Estancia estancia){
        Estancia newEstancia = estanciaRepository.save(estancia);
        return newEstancia;
    }

    public ResponseEntity<Estancia> updateEstancia(Integer id, Estancia estancia){
        Estancia currentEstancia = this.getEstanciaById(id);
        if(currentEstancia != null){
            Estancia existingEstancia = currentEstancia;

            if (estancia.getFechaEntrada() != null){
                existingEstancia.setFechaEntrada(estancia.getFechaEntrada());
            }
            if (estancia.getFechaSalida() != null){
                existingEstancia.setFechaSalida(estancia.getFechaSalida());
            }
            if (estancia.getVehiculo() != null){
                existingEstancia.setVehiculo(estancia.getVehiculo());
            }

            return new ResponseEntity<>(estanciaRepository.save(existingEstancia), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public List<EstanciaReportItem> getReporteEstancias() {
        return vehiculoService.findAll().stream().map(vehiculo -> {
            BigDecimal montoAPagar = Constants.TASA_POR_MINUTO.multiply(new BigDecimal(vehiculo.getMinutosAcumulados()));

            return EstanciaReportItem.builder()
                    .placa(vehiculo.getPlaca())
                    .minutosEstacionados(vehiculo.getMinutosAcumulados())
                    .cantidadAPagar(montoAPagar)
                    .build();
        }).collect(Collectors.toList());
    }

    public Estancia finalizarEstancia(Integer id, FinalizarEstanciaRequest finalizarEstanciaRequest) {
        Estancia estancia = getEstanciaById(id);
        estancia.setFechaSalida(finalizarEstanciaRequest.getFechaSalida());
        estanciaRepository.save(estancia);
        return estancia;
    }
}
