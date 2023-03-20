package com.NoHexRoger.Backend.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EstanciaResponse {
    private Integer id;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private Integer vehiculoId;

}
