import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Vehiculo } from 'src/app/shared/vehiculo';
import { TipoVehiculo } from 'src/app/shared/tipoVehiculo';

@Injectable({
  providedIn: 'root',
})
export class VehiculoService {
  constructor(private http: HttpClient) {}

  url: string = 'http://localhost:8080/api/v1/vehiculos';

  getVehiculos(): Observable<Vehiculo[]> {
    return this.http.get<Vehiculo[]>(this.url);
  }
}

@Injectable({
  providedIn: 'root',
})
export class TipoVehiculoService {
  constructor(private http: HttpClient) {}

  url: string = 'http://localhost:8080/api/v1/tipo-vehiculo';

  getTipoVehiculo(): Observable<TipoVehiculo[]> {
    return this.http.get<TipoVehiculo[]>(this.url);
  }
}
