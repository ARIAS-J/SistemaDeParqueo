package com.NoHexRoger.Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoRequest {
    private String placa;
    private Long tipoVehiculoId;
}
