import { Component, OnInit } from '@angular/core';
import { Estancia } from 'src/app/shared/estancia';
import { EstanciasService } from './estancias.service';

@Component({
  selector: 'app-estancias',
  templateUrl: './estancias.component.html',
  styleUrls: ['./estancias.component.css'],
})
export class EstanciasComponent implements OnInit {
  estancias: Estancia[] = [];
  selectedEstancia!: Estancia | undefined;
  showEndStayModal: boolean = false;

  constructor(private estanciasService: EstanciasService) {}

  ngOnInit(): void {
    this.estanciasService
      .getEstancias()
      .subscribe((data) => (this.estancias = data));
  }

  closeEndStayModal() {
    this.showEndStayModal = false;
    this.selectedEstancia = undefined;
  }

  openEndStayModal(stay: Estancia) {
    this.selectedEstancia = stay;
    this.showEndStayModal = true;
  }
}
