import { Pipe, PipeTransform } from '@angular/core';
import { Vehiculo } from 'src/app/shared/vehiculo';

@Pipe({
  name: 'pagination',
})
export class FiltroPipe implements PipeTransform {
  transform(vehiculos: Vehiculo[], page: number = 0): Vehiculo[] {
    return vehiculos.slice(page, page + 5);
  }
}
