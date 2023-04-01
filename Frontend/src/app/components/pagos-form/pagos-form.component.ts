import { Component, Input, OnInit } from '@angular/core';
import { VehiculoService } from 'src/app/pages/vehiculos/Service/vehiculo.service';
import { Vehiculo } from 'src/app/shared/vehiculo';

@Component({
  selector: 'app-pagos-form',
  templateUrl: './pagos-form.component.html',
  styleUrls: ['./pagos-form.component.css'],
})
export class PagosFormComponent implements OnInit {
  showCreditCardForm: boolean = false;
  @Input() vehiculo: Vehiculo | undefined;

  constructor(private vehiculoService: VehiculoService) {}

  ngOnInit(): void {}

  creditCardFormIsOpen() {
    this.showCreditCardForm = true;
  }
  creditCardFormIsClose() {
    this.showCreditCardForm = false;
  }

  payWithCash() {
    if (this.vehiculo)
      this.vehiculoService.pagarDeuda(this.vehiculo.placa).subscribe(() => {
        alert('Pago con exito');
        window.location.reload();
      });
  }
}
