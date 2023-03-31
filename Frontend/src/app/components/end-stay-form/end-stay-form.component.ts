import { Component, Input, OnInit } from '@angular/core';
import { EstanciasService } from 'src/app/pages/estancias/estancias.service';
import { Estancia } from 'src/app/shared/estancia';

@Component({
  selector: 'app-end-stay-form',
  templateUrl: './end-stay-form.component.html',
  styleUrls: ['./end-stay-form.component.css'],
})
export class EndStayFormComponent implements OnInit {
  @Input() stay: Estancia | undefined;
  fechaFinalizacion!: string;

  constructor(private estanciasService: EstanciasService) {}

  ngOnInit(): void {
    this.fechaFinalizacion = this.estanciasService.getCurrentLocalISODate();
  }

  onSubmit() {
    console.log({ fechaFinalizacion: this.fechaFinalizacion });
    if (this.stay) {
      this.estanciasService
        .finalizarEstancia({
          id: this.stay?.id,
          fechaSalida: this.fechaFinalizacion,
        })
        .subscribe(() => {
          alert('Done!');
        });
    }
  }
}
