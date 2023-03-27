import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout/layout.component';
import { HomeComponent } from './pages/home/home.component';
import { EstanciasComponent } from './pages/estancias/estancias.component';
<<<<<<< HEAD
import { VehiculosComponent } from './pages/vehiculos/vehiculos.component';
=======
import { ButtonComponent } from './components/button/button.component';
>>>>>>> 6cb4f80274d7771f18aaa839f6625e6818b61fa7

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    HomeComponent,
    EstanciasComponent,
<<<<<<< HEAD
    VehiculosComponent
=======
    ButtonComponent
>>>>>>> 6cb4f80274d7771f18aaa839f6625e6818b61fa7
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
