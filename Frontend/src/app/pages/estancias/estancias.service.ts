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
}
