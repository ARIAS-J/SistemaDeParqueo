package com.NoHexRoger.Backend.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "estancia")
@Getter
@Setter
@NoArgsConstructor
public class Estancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @CreationTimestamp
    private LocalDateTime fechaEntrada;

    @Column
    @CreationTimestamp
    private LocalDateTime fechaSalida;

    @ManyToOne
    @JoinColumn(name = "vehiculoId", nullable = false)
    private Vehiculo vehiculo;

}
