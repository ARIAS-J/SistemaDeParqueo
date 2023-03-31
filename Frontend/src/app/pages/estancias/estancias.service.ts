import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estancia } from 'src/app/shared/estancia';

@Injectable({
  providedIn: 'root',
})
export class EstanciasService {
  url: string = 'http://localhost:8080/api/v1/estancias';

  constructor(private http: HttpClient) {}

  getEstancias() {
    return this.http.get<Estancia[]>(this.url);
  }

  finalizarEstancia({ id, fechaSalida }: { id: number; fechaSalida: string }) {
    return this.http.post(this.url + `/${id}/finalizar`, { fechaSalida });
  }

  postEstancia(estancia: { placa: string; fechaEntrada: string }) {
    return this.http.post(this.url, estancia);
  }

  getCurrentLocalISODate() {
    const now = new Date();
    const date = {
      year: now.getFullYear(),
      month: this.zeroPad(now.getMonth() + 1),
      day: this.zeroPad(now.getDate()),
      hour: this.zeroPad(now.getHours()),
      minute: this.zeroPad(now.getMinutes()),
      seconds: this.zeroPad(now.getSeconds()),
    };

    return `${date.year}-${date.month}-${date.day}T${date.hour}:${date.minute}:${date.seconds}`;
  }

  private zeroPad(value: number): string {
    if (value < 10) return '0' + value.toString();
    return value.toString();
  }
}
