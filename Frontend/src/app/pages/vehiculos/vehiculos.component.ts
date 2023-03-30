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
  showAddVehiculoModal: boolean = false;
  showPagosModal: boolean = false;

  constructor(private vehiculoService: VehiculoService) {}

  ngOnInit(): void {
    this.vehiculoService
      .getVehiculos()
      .subscribe((vehiculos) => (this.vehiculos = vehiculos));
  }

  nextPage() {
    this.page += 5;
  }

  prevPage() {
    if (this.page > 0) this.page -= 5;
  }

  modalVehiculoIsOpen() {
    this.showAddVehiculoModal = true;
  }

  modalVehiculoHandleClose() {
    this.showAddVehiculoModal = false;
  }

  modalPagosIsOpen() {
    this.showPagosModal = true;
  }

  modalPagosHandleClose() {
    this.showPagosModal = false;
  }
}
