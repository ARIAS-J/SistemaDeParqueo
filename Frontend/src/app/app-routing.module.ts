import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EstanciasComponent } from './pages/estancias/estancias.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'estancias',
    component: EstanciasComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
