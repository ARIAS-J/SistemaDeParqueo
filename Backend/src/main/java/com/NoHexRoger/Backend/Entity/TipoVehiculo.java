package com.NoHexRoger.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoVehiculo {
    @Id
    private Long id;
    private String tipo;
}
