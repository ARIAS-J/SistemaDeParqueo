import { Component, OnInit } from '@angular/core';
import { Vehiculo } from 'src/app/shared/vehiculo';
import { VehiculoService } from './Service/vehiculo.service';

@Component({
  selector: 'app-vehiculos',
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css'],
})
export class VehiculosComponent implements OnInit {
  public vehiculos: Vehiculo[] = [];

  public page: number = 0;

  constructor(private vehiculoService: VehiculoService) {}

  ngOnInit(): void {
    this.vehiculoService
      .getVehiculos()
      .subscribe((vehiculos) => (this.vehiculos = vehiculos));
  }

  nextPage() {
    if (this.page < 5) this.page += 5;
  }

  prevPage() {
    if (this.page > 0) this.page -= 5;
  }
}
