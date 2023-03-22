package com.NoHexRoger.Backend.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EstanciaRequest {
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private String vehiculoId;
}
