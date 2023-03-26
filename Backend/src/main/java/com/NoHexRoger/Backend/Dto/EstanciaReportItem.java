package com.NoHexRoger.Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstanciaReportItem {
    private String placa;
    private Integer minutosEstacionados;
    private BigDecimal cantidadAPagar;
}
