import { Component, OnInit } from '@angular/core';
import { EstanciasService } from 'src/app/pages/estancias/estancias.service';
import { VehiculoService } from 'src/app/pages/vehiculos/Service/vehiculo.service';
import { Vehiculo } from 'src/app/shared/vehiculo';

@Component({
  selector: 'app-create-stay-form',
  templateUrl: './create-stay-form.component.html',
  styleUrls: ['./create-stay-form.component.css'],
})
export class CreateStayFormComponent implements OnInit {
  fechaEntrada!: string;
  placa!: string;
  vehiculos: Vehiculo[] = [];

  constructor(
    private estanciasService: EstanciasService,
    private vehiculosService: VehiculoService
  ) {}

  ngOnInit(): void {
    this.fechaEntrada = this.estanciasService.getCurrentLocalISODate();
    this.vehiculosService
      .getVehiculos()
      .subscribe((data) => (this.vehiculos = data));
  }

  handleSubmit() {
    this.estanciasService
      .postEstancia({
        placa: this.placa,
        fechaEntrada: this.fechaEntrada,
      })
      .subscribe(() => {
        alert('done!');
      });
  }
}
