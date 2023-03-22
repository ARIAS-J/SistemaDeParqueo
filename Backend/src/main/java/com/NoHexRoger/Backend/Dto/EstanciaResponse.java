package com.NoHexRoger.Backend.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EstanciaResponse {
    private Integer id;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private String vehiculoId;

}
