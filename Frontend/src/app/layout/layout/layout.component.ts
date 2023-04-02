import { Component } from '@angular/core';
import { EstanciasService } from 'src/app/pages/estancias/estancias.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css'],
})
export class LayoutComponent {
  showDeudasTable: boolean = false;
  links: { label: string; path: string }[] = [
    {
      label: 'Home',
      path: '/',
    },
    {
      label: 'Vehiculos',
      path: '/vehiculos',
    },
    {
      label: 'Estancias',
      path: '/estancias',
    },
  ];

  constructor(private estanciasService: EstanciasService) {}

  switchShowDeudasModal(value: boolean) {
    this.showDeudasTable = value;
  }

  handleComenzarMes() {
    console.log('CLICKED');
    this.estanciasService.comenzarMes().subscribe(() => {
      alert('Done!');
      window.location.reload();
    });
  }
}
