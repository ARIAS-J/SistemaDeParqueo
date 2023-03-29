import { Component, OnInit } from '@angular/core';
import {
  SwitchService,
  TipoVehiculoService,
} from 'src/app/pages/vehiculos/Service/vehiculo.service';
import { TipoVehiculo } from 'src/app/shared/tipoVehiculo';

@Component({
  selector: 'app-vehiculo-modal',
  templateUrl: './vehiculo-modal.component.html',
  styleUrls: ['./vehiculo-modal.component.css'],
})
export class VehiculoModalComponent implements OnInit {
  public tiposVehiculos: TipoVehiculo[] = [];

  constructor(
    private modalSS: SwitchService,
    private tiposVehiculoService: TipoVehiculoService
  ) {}

  ngOnInit(): void {
    this.tiposVehiculoService
      .getTipoVehiculo()
      .subscribe((tiposVehiculos) => (this.tiposVehiculos = tiposVehiculos));
  }

  modalIsClose() {
    this.modalSS.$modal.emit(false);
  }
}
