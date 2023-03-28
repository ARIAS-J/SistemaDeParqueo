import { Component, OnInit } from '@angular/core';
import { Estancia } from 'src/app/shared/estancia';
import { EstanciasService } from './estancias.service';

@Component({
  selector: 'app-estancias',
  templateUrl: './estancias.component.html',
  styleUrls: ['./estancias.component.css'],
})
export class EstanciasComponent implements OnInit {
  estancias!: Estancia[];
  selectedEstancia!: Estancia;

  constructor(private estanciasService: EstanciasService) {}

  ngOnInit(): void {
    this.estanciasService
      .getEstancias()
      .subscribe((data) => (this.estancias = data));
  }
}
