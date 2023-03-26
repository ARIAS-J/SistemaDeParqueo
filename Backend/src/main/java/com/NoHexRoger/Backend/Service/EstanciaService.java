package com.NoHexRoger.Backend.Service;

import com.NoHexRoger.Backend.Dto.EstanciaReportItem;
import com.NoHexRoger.Backend.Dto.EstanciaRequest;
import com.NoHexRoger.Backend.Dto.EstanciaResponse;
import com.NoHexRoger.Backend.Dto.FinalizarEstanciaRequest;
import com.NoHexRoger.Backend.Entity.Estancia;
import com.NoHexRoger.Backend.Entity.Vehiculo;
import com.NoHexRoger.Backend.Repository.EstanciaRepository;
import com.NoHexRoger.Backend.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstanciaService {
    @Autowired
    private EstanciaRepository estanciaRepository;

    @Autowired
    private VehiculoService vehiculoService;

    public List<Estancia> getEstancias(){
        return estanciaRepository.findAll();
    }

    public Estancia getEstanciaById(Integer id){
        return estanciaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public EstanciaResponse createEstancia(EstanciaRequest estanciaRequest){
        Vehiculo vehiculo = vehiculoService.getVehiculoById(estanciaRequest.getPlaca());

        Estancia estancia = Estancia.builder()
                .vehiculo(vehiculo)
                .fechaEntrada(estanciaRequest.getFechaEntrada())
                .build();

        estanciaRepository.save(estancia);

        EstanciaResponse estanciaResponse = EstanciaResponse.builder()
                .id(estancia.getId())
                .vehiculoId(estancia.getVehiculo().getPlaca())
                .fechaEntrada(estancia.getFechaEntrada())
                .fechaSalida(estancia.getFechaSalida())
                .build();


        return estanciaResponse;
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

        if (estancia.getFechaEntrada().isAfter(finalizarEstanciaRequest.getFechaSalida())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        estancia.setFechaSalida(finalizarEstanciaRequest.getFechaSalida());
        estanciaRepository.save(estancia);

        // calculate stay duration in minutes
        Duration duration = Duration.between(estancia.getFechaEntrada(), estancia.getFechaSalida());
        Integer minutesPassed = Long.valueOf(duration.toMinutes()).intValue();

        // calculate deuda
        BigDecimal deuda = new BigDecimal(minutesPassed).multiply(Constants.TASA_POR_MINUTO);

        // add it to the vehicle entity
        Vehiculo vehiculo = estancia.getVehiculo();
        Integer minutosAcumulados = minutesPassed + vehiculo.getMinutosAcumulados();
        BigDecimal deudaAcumulada = deuda.add(vehiculo.getDeudaAcumulada()).round(new MathContext(2, RoundingMode.HALF_UP));
        vehiculo.setMinutosAcumulados(minutosAcumulados);
        vehiculo.setDeudaAcumulada(deudaAcumulada);
        vehiculoService.updateVehiculo(vehiculo);

        return estancia;
    }
}
