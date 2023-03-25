package com.NoHexRoger.Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoResponse {
    private String placa;
    private Integer tiempoAcumulado;
    private Long tipoVehiculoId;
}
