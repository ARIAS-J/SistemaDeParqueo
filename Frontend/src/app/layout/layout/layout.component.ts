import { Component } from '@angular/core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css'],
})
export class LayoutComponent {
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
}
