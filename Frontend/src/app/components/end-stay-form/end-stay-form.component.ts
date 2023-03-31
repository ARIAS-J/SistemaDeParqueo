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
    const now = new Date();
    const date = {
      year: now.getFullYear(),
      month: this.zeroPad(now.getMonth() + 1),
      day: this.zeroPad(now.getDate()),
      hour: this.zeroPad(now.getHours()),
      minute: this.zeroPad(now.getMinutes()),
      seconds: this.zeroPad(now.getSeconds()),
    };

    this.fechaFinalizacion = `${date.year}-${date.month}-${date.day}T${date.hour}:${date.minute}:${date.seconds}`;
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

  private zeroPad(value: number): string {
    if (value < 10) return '0' + value.toString();
    return value.toString();
  }
}
