export interface Vehiculo {
  id: number;
  placa: string;
  minutosAcumulados: number;
  deudaAcumulada: number;
  tipoVehiculo: {
    id: number;
    tipo: string;
  };
}
