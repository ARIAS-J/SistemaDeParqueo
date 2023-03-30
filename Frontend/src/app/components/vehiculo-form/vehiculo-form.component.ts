import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TipoVehiculoService } from 'src/app/pages/vehiculos/Service/vehiculo.service';
import { TipoVehiculo } from 'src/app/shared/tipoVehiculo';

@Component({
  selector: 'app-vehiculo-form',
  templateUrl: './vehiculo-form.component.html',
  styleUrls: ['./vehiculo-form.component.css'],
})
export class VehiculoFormComponent implements OnInit {
  tipoVehiculos: TipoVehiculo[] = [];

  constructor(
    private tipoVehiculoService: TipoVehiculoService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.tipoVehiculoService
      .getTipoVehiculo()
      .subscribe((tipoVehiculos) => (this.tipoVehiculos = tipoVehiculos));
  }

  onSubmit(vehiculo: { placa: string; tipoVehiculoId: number }) {
    console.log(vehiculo);

    this.http
      .post('http://localhost:8080/api/v1/vehiculos', vehiculo)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
