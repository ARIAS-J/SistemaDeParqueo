export interface Estancia {
  id: number;
  fechaEntrada: string;
  fechaSalida?: string;
  vehiculo: {
    placa: string;
    minutosAcumulados: number;
    deudaAcumulada: number;
    tipoVehiculo: {
      id: number;
      tipo: string;
    };
  };
}
