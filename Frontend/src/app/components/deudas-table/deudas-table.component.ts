import { Component, OnInit } from '@angular/core';
import { EstanciasService } from 'src/app/pages/estancias/estancias.service';
import { DeudaItem } from 'src/app/shared/deudaItem';

@Component({
  selector: 'app-deudas-table',
  templateUrl: './deudas-table.component.html',
  styleUrls: ['./deudas-table.component.css'],
})
export class DeudasTableComponent implements OnInit {
  deudas: DeudaItem[] = [];

  constructor(private estanciasService: EstanciasService) {}

  ngOnInit(): void {
    this.estanciasService
      .getDeudasReport()
      .subscribe((data) => (this.deudas = data));
  }
}
