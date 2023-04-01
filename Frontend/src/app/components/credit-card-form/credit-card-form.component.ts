import { Component, Input } from '@angular/core';
import { VehiculoService } from 'src/app/pages/vehiculos/Service/vehiculo.service';
import { Vehiculo } from 'src/app/shared/vehiculo';

@Component({
  selector: 'app-credit-card-form',
  templateUrl: './credit-card-form.component.html',
  styleUrls: ['./credit-card-form.component.css'],
})
export class CreditCardFormComponent {
  @Input() payFunct!: () => void;

  @Input() vehiculo: Vehiculo | undefined;

  constructor(private vehiculoService: VehiculoService) {}

  payWithCard() {
    if (this.vehiculo)
      this.vehiculoService.pagarDeuda(this.vehiculo.placa).subscribe(() => {
        alert('Pago con exito');
        window.location.reload();
      });
  }
}
