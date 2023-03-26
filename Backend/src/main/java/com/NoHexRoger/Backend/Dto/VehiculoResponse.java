package com.NoHexRoger.Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoResponse {
    private String placa;
    private int minutosAcumulados;
    private BigDecimal deudaAcumulada;
    private Long tipoVehiculoId;
}
